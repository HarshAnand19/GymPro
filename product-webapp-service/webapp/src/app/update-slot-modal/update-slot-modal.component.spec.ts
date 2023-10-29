import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSlotModalComponent } from './update-slot-modal.component';

describe('UpdateSlotModalComponent', () => {
  let component: UpdateSlotModalComponent;
  let fixture: ComponentFixture<UpdateSlotModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateSlotModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateSlotModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
