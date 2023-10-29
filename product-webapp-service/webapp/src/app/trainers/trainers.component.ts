import { Component, OnInit } from '@angular/core';
import { SlotService } from '../slot.service';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component'; // Import your confirmation dialog component

import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-trainers',
  templateUrl: './trainers.component.html',
  styleUrls: ['./trainers.component.css'],
})
export class TrainerComponent implements OnInit {
  trainers: any[] = [];
  trainerData: any = [];
  showForm: boolean = false; // Initialize to hide the form

  // Function to toggle the visibility of the form
  toggleForm() {
    this.showForm = !this.showForm;
  }

  constructor(private gymService: SlotService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.fetchTrainers();
  }

  fetchTrainers() {
    this.gymService.getTrainers().subscribe((data) => {
      this.trainers = data;
      // console.log('trainer data from database', this.trainers);
    });
  }

  editTrainerDetails(index: any, gym: any) {
    const id = gym.trainerId;
    // const params = new HttpParams()
    //   .set('trainerName', gym.trainerName)
    //   .set('trainerAddress', gym.trainerAddress)
    //   .set('trainerPhone', gym.trainerPhone)
    //   .set('slotId', gym.slotId);

    const requestBody = {
      slotId: gym.slotId,
      trainerAddress: gym.trainerAddress,
      trainerName: gym.trainerName,
      trainerPhone: gym.trainerPhone,
    };

    this.gymService.editTrainerDetails(id, requestBody).subscribe(() => {});
  }

  addTrainer(gym: any[]) {
    console.log('data from form', this.trainerData);
    // const requestBody = { gym: gym }
    const requestBody = {
      slotId: this.trainerData.slotId,
      trainerAddress: this.trainerData.trainerAddress,
      trainerName: this.trainerData.trainerName,
      trainerPhone: this.trainerData.trainerPhone,
    };
    // console.log('body', requestBody);
    this.gymService.addTrainer(requestBody).subscribe(() => {
      this.fetchTrainers();
    });
  }

  toggleUpdateForm(index: number) {
    this.trainers[index].showUpdateForm = !this.trainers[index].showUpdateForm;
  }

  // DeleteTrainer(id:any){
  //   this.gymService.deleteTrainer(id).subscribe(() =>{
  //     this.fetchTrainers();
  //   })
    
  // }


  DeleteTrainer(id: any) {
    // Open the confirmation dialog
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
      data: 'Are you sure you want to delete this trainer?',
    });

    // Subscribe to the dialog result
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        // User confirmed deletion, proceed with deletion
        this.gymService.deleteTrainer(id).subscribe(() => {
          this.fetchTrainers();
        });
      }
    });
  }
}
