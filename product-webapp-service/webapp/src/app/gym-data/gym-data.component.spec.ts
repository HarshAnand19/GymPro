import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GymDataComponent } from './gym-data.component';

describe('GymDataComponent', () => {
  let component: GymDataComponent;
  let fixture: ComponentFixture<GymDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GymDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GymDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
