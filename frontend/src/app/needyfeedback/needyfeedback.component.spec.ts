import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedyfeedbackComponent } from './needyfeedback.component';

describe('NeedyfeedbackComponent', () => {
  let component: NeedyfeedbackComponent;
  let fixture: ComponentFixture<NeedyfeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeedyfeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedyfeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
