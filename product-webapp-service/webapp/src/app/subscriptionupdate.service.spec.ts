import { TestBed } from '@angular/core/testing';

import { SubscriptionupdateService } from './subscriptionupdate.service';

describe('SubscriptionupdateService', () => {
  let service: SubscriptionupdateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubscriptionupdateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
