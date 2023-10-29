import { Component, OnInit } from '@angular/core';
import { SlotService } from '../slot.service';
import { HttpParams } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
@Component({
  selector: 'app-gym-eqipments',
  templateUrl: './gym-eqipments.component.html',
  styleUrls: ['./gym-eqipments.component.css'],
})
export class GymEqipmentsComponent implements OnInit {
  gymEquipments: any[] = [];
  equipmentData: any = [];
  showUpdateForm: boolean = false;

  showForm: boolean = false; // Initialize to hide the form

  // Function to toggle the visibility of the form
  toggleForm() {
    this.showForm = !this.showForm;
  }
  constructor(private gymService: SlotService,  private dialog: MatDialog) {}

  ngOnInit(): void {
    this.fetchGymEquipments();
  }


  fetchGymEquipments() {
    this.gymService.getGymEquipments().subscribe((Data) => {
      this.gymEquipments = Data;
      // console.log('equip', this.gymEquipments);
    });
  }
  updateGymEquipments(index: any, gym: any) {
    const id = gym.equipmentId;
    const params = new HttpParams()
      .set('equipmentId', gym.equipmentId)
      .set('equipmentName', gym.equipmentName)
      .set('equipmentDetail', gym.equipmentDetail)
      .set('equipmentQualityStatus', gym.equipmentQualityStatus);

    this.gymService.updateGymEquipments(id, params).subscribe(() => {});
  }


  addEquipment(gym: any[]) {
    console.log('data from form', this.equipmentData);
    // const requestBody = { gym: gym }
    const requestBody = {
      // slotId: this.equipmentData.slotId,
      equipmentQualityStatus: this.equipmentData.equipmentQualityStatus,
      equipmentName: this.equipmentData.equipmentName,
      equipmentDetail: this.equipmentData.equipmentDetail,
    };
    // console.log('body', requestBody);
    this.gymService.addEquipment(requestBody).subscribe(() => {
      this.fetchGymEquipments();
    });
  }

  toggleUpdateForm(index: number) {
    this.gymEquipments[index].showUpdateForm = !this.gymEquipments[index].showUpdateForm;
  }

  // DeleteEquipment(id:any){
  //   this.gymService.deleteEquipment(id).subscribe(() =>{
  //     this.fetchGymEquipments();
  //   })
  // }

  DeleteEquipment(id: any) {
    // Open the confirmation dialog
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
      data: 'Are you sure you want to delete this equipment?',
    });


    dialogRef.afterClosed().subscribe((result) => {
      if (result) {

        this.gymService.deleteEquipment(id).subscribe(() => {
          this.fetchGymEquipments();
        });
      }
    });
  }
}
