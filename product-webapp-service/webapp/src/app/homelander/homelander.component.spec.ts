import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomelanderComponent } from './homelander.component';

describe('HomelanderComponent', () => {
  let component: HomelanderComponent;
  let fixture: ComponentFixture<HomelanderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomelanderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomelanderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
