import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignuputilComponent } from './signuputil.component';

describe('SignuputilComponent', () => {
  let component: SignuputilComponent;
  let fixture: ComponentFixture<SignuputilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignuputilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignuputilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
