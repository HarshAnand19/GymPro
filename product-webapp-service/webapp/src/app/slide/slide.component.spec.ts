import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlideComponent } from './slide.component';

describe('SlideComponent', () => {
  let component: SlideComponent;
  let fixture: ComponentFixture<SlideComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlideComponent]
    });
    fixture = TestBed.createComponent(SlideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
