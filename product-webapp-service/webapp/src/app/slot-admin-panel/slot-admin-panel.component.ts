import { Component, OnInit, ViewChild } from '@angular/core';
import { SlotService } from '../slot.service';
import { UpdateSlotModalComponent } from '../update-slot-modal/update-slot-modal.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-slot-admin-panel',
  templateUrl: './slot-admin-panel.component.html',
  styleUrls: ['./slot-admin-panel.component.css']
})
export class SlotAdminPanelComponent implements OnInit {
  slots: any[] = [];
  selectedSlot: any;
  
  @ViewChild('updateSlotModal') updateSlotModal!: UpdateSlotModalComponent;

  constructor(private slotService: SlotService, private router: Router) {}

  ngOnInit(): void {
    this.slotService.getSlots().subscribe((data: any[]) => {
      console.log('SlotAdminPanelComponent initialized');
      this.slots = data;
    });
  }
  
  openUpdateModal(slot: any) {
    console.log('Open modal clicked');
    this.selectedSlot = { ...slot }; // Create a copy of the selected slot
    this.updateSlotModal.openModal();
  }

  closeUpdateModal() {
    
    if (this.updateSlotModal) {
      this.updateSlotModal.closeModal();
    } else {
      console.error('updateSlotModal is undefined');
    }
  }

  updateSlot(updatedData: any) {
    
    if (!this.selectedSlot || !this.selectedSlot.slotId) {
      console.error('Invalid slot data.');
      return;
    }
    this.slotService.updateSlot(this.selectedSlot.slotId, updatedData).subscribe(
      (response) => {
        console.log('Slot updated successfully', response);
        this.selectedSlot = null;
        this.closeUpdateModal();
        window.location.reload();
      },
      
      (error) => {

        console.error('Error updating slot', error);
      }
      
    );
  }

  confirmDeleteSlot(slotId: number) {
    const confirmation = window.confirm('Are you sure you want to delete this slot?');

    if (confirmation) {
      this.deleteSlot(slotId);
    }
  }

  deleteSlot(slotId: number) {
    this.slotService.deleteSlot(slotId).subscribe(() => {
      window.location.reload();
    });
  }
}
