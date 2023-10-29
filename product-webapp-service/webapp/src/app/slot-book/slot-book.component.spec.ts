import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotBookComponent } from './slot-book.component';

describe('SlotBookComponent', () => {
  let component: SlotBookComponent;
  let fixture: ComponentFixture<SlotBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SlotBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SlotBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
