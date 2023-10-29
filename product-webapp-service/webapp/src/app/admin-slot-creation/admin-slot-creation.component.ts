import { Component, OnInit } from '@angular/core';
import { SlotService } from '../slot.service';
import { DatePipe } from '@angular/common';
import { Trainer } from '../trainers.model';


@Component({
  selector: 'app-admin-slot-creation',
  templateUrl: './admin-slot-creation.component.html',
  styleUrls: ['./admin-slot-creation.component.css']
})
export class AdminSlotCreationComponent implements OnInit {
  slot: any = {
    slotName: '',
    trainerId: '',
    trainerName: '',
    slotDate: '',
    startTime: '',
    endTime: '',
    personsAllowed: ''
  };

  isInvalidDateTime: boolean = false;
  isEndTimeEarlier: boolean = false;
  trainers: Trainer[] = [];
  selectedTrainer: Trainer = { trainerId: '', trainerName: '' };

  constructor(
    private slotService: SlotService,
    private datePipe: DatePipe,
  
  ) {}

  ngOnInit() {
    this.loadTrainers();
  }

  loadTrainers() {
    this.slotService.getAllTrainers().subscribe(
      (trainers) => {
        this.trainers = trainers;
      },
      (error) => {
        console.error('Error loading trainers... Not Saving in Database', error);
      }
    );
  }

  onTrainerSelect() {
    
    const selectedTrainer = this.trainers.find(t => t.trainerName === this.slot.trainerName);
    
    if (selectedTrainer) {
      this.selectedTrainer = selectedTrainer;
      console.log(this.selectedTrainer);
    } else {
      this.selectedTrainer = { trainerId: '', trainerName: '' };
    }
  }
  

  createSlot() {
    const currentDate = new Date();
    const selectedDate = new Date(this.slot.slotDate);
    const currentTime = currentDate.toLocaleTimeString().slice(0, 5);

    if (
      selectedDate < currentDate ||
      (selectedDate.getTime() === currentDate.getTime() && (this.slot.startTime ?? '') < currentTime)
    ) {
      this.isInvalidDateTime = true;
      this.isEndTimeEarlier = false;
      return;
    } else {
      this.isInvalidDateTime = false;
    }

    if ((this.slot.endTime ?? '') <= (this.slot.startTime ?? '')) {
      this.isEndTimeEarlier = true;
      this.isInvalidDateTime = false;
      return;
    } else {
      this.isEndTimeEarlier = false;
    }

    /*console.log('Slot created:', this.slot);*/

    const slotData = {
      slotName: this.slot.slotName,
      trainerId: this.selectedTrainer.trainerId, 
      trainerName: this.slot.trainerName,
      slotDate: this.slot.slotDate,
      startTime: this.slot.startTime,
      endTime: this.slot.endTime,
      personsAllowed: this.slot.personsAllowed
    };
    console.log(slotData);
    /*const observer = {
      next: (response: any) => {
        console.log('Slot created successfully', response);
        this.resetForm();
      },
      error: (error: any) => {
        console.log('Data is not saved in Database');
        console.error('Error creating slot', error);
      }
    };*/

    this.slotService.createSlot(slotData).subscribe((response: any)=>{
      console.log(response);
      this.resetForm();
    },
    (error: any) => {
      console.log('Data is not saved in Database');
      console.error('Error creating slot', error);}
    );
  }

  resetForm() {
    this.slot = {
      slotName: '',
      trainerId: '',
      trainerName: '',
      slotDate: '',
      startTime: '',
      endTime: '',
      personsAllowed: ''
    };
  }
}
