import { TestBed } from '@angular/core/testing';

import { SlotBookingService } from './slot-booking.service';

describe('SlotBookingService', () => {
  let service: SlotBookingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SlotBookingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
