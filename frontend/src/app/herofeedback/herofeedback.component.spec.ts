import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HerofeedbackComponent } from './herofeedback.component';

describe('HerofeedbackComponent', () => {
  let component: HerofeedbackComponent;
  let fixture: ComponentFixture<HerofeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HerofeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HerofeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
