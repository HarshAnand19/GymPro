import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSlotCreationComponent } from './admin-slot-creation.component';

describe('AdminSlotCreationComponent', () => {
  let component: AdminSlotCreationComponent;
  let fixture: ComponentFixture<AdminSlotCreationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminSlotCreationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSlotCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
