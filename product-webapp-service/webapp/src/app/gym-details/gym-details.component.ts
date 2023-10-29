import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SlotService } from 'src/app/slot.service';

@Component({
  selector: 'app-gym-details',
  templateUrl: './gym-details.component.html',
  styleUrls: ['./gym-details.component.css'],
})
export class GymDetailsComponent implements OnInit {
  gymDetails: any = [];
  showUpdateForm: boolean = false;

  constructor(private gymService: SlotService) {}

  ngOnInit(): void {
    this.fetchGymDetails();
  }
  toggleUpdateForm() {
    this.showUpdateForm = !this.showUpdateForm;
  }

  onFileChange(event: any) {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
      console.log('Selected file:', selectedFile.name);
    }
  }

  fetchGymDetails() {
    this.gymService.getGymDetails().subscribe((data) => {
      this.gymDetails = data;
      // console.log('gym details', this.gymDetails);
    });
  }
  updateGymDetails(gym: any) {
    const id = gym.gymId;
    const params = new HttpParams()
      .set('gymName', gym.gymName)
      .set('gymEmail', gym.gymEmail)
      .set('gymAddress', gym.gymAddress)
      .set('gymPhone', gym.gymPhone);

    this.gymService.updateGymDetails(id, params).subscribe(() => {});
  }

  updateProfilePicture(gymId: string) {
    const fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.accept = 'image/*';

    fileInput.addEventListener('change', (event: any) => {
      const selectedFile = event.target.files[0];

      if (selectedFile) {
        const formData = new FormData();
        formData.append('profilePicture', selectedFile);

        this.gymService
          .uploadProfilePicture(gymId, formData)
          .subscribe(() => {});
      }
    });

    fileInput.click(); 
  }
}
