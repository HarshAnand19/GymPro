import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GymEqipmentsComponent } from './gym-eqipments.component';

describe('GymEqipmentsComponent', () => {
  let component: GymEqipmentsComponent;
  let fixture: ComponentFixture<GymEqipmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GymEqipmentsComponent]
    });
    fixture = TestBed.createComponent(GymEqipmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
