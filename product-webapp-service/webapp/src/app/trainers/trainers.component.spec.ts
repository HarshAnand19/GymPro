import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerComponent } from './trainers.component';

describe('TrainersComponent', () => {
  let component: TrainerComponent;
  let fixture: ComponentFixture<TrainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TrainerComponent]
    });
    fixture = TestBed.createComponent(TrainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
