import { TestBed } from '@angular/core/testing';

import { RegistrationserviceService } from './registrationservice.service';

describe('RegistrationserviceService', () => {
  let service: RegistrationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
