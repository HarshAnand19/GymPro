import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotAdminPanelComponent } from './slot-admin-panel.component';

describe('SlotAdminPanelComponent', () => {
  let component: SlotAdminPanelComponent;
  let fixture: ComponentFixture<SlotAdminPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SlotAdminPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SlotAdminPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
