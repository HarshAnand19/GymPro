import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { SlotService } from '../slot.service';
import { Trainer } from '../trainers.model';

@Component({
  selector: 'app-update-slot-modal',
  templateUrl: './update-slot-modal.component.html',
  styleUrls: ['./update-slot-modal.component.css']
})
export class UpdateSlotModalComponent implements OnInit {
  @Input() slot: any = {}; 
  @Output() updateSlot: EventEmitter<any> = new EventEmitter();
  showModal: boolean = false;
  currentDate!: Date; 
  trainers: Trainer[] = [];
  selectedTrainer: Trainer = { trainerId: '', trainerName: '' };

  constructor(private datePipe: DatePipe, private trainerService : SlotService) {}

  ngOnInit()
   {
    this.loadTrainers();

    // Initialize the slot object here if it's not provided from the parent component.
    if (!this.slot) {
      this.slot = {
        slotName: '', // Provide default values for the properties you plan to edit
        trainerName: '',
        slotDate: '', // Ensure you have slotDate in the default object
        startTime: '',
        endTime: '',
        personsAllowed: 0 // Provide default value as needed
        // Add other properties with default values as needed
      };
      this.trainerService.getAllTrainers().subscribe((data) => {
        this.trainers = data;
  
        // Set the selectedTrainer to the ID of the trainer associated with the slot
        this.selectedTrainer = this.slot.trainerId;
      });
  
      // Get the current date and time
      this.currentDate = new Date();
    }
    // Get the current date and time
    this.currentDate = new Date();
  }
  loadTrainers() {
    this.trainerService.getAllTrainers().subscribe(
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

  

  openModal() {
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }

  validateTime() {
    const startTime = new Date(this.slot.slotDate + 'T' + this.slot.startTime);
    const endTime = new Date(this.slot.slotDate + 'T' + this.slot.endTime);

    // Check if end time is less than start time
    if (endTime <= startTime) {
      alert('End time should be greater than start time.');
      return;
    }

    // Check if the date is the current date
    const slotDate = new Date(this.slot.slotDate);
    const currentDate = new Date();
    if (
      slotDate.getFullYear() === currentDate.getFullYear() &&
      slotDate.getMonth() === currentDate.getMonth() &&
      slotDate.getDate() === currentDate.getDate()
    ) {
      const currentTime = this.datePipe.transform(currentDate, 'HH:mm') ?? '00:00';
      if (this.slot.startTime <= currentTime) {
        alert('Start time cannot be less than the current time.');
        return;
      }
    }

    // If all validations pass, emit the update event
    this.onDoneClick();
  }
  // Fetch the list of trainers when the component initializes
  


  onDoneClick() {
    // This method is called when the "Done" button is clicked
    this.updateSlot.emit(this.slot);
    this.closeModal();
  }
}
