import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupheroComponent } from './signuphero.component';

describe('SignupheroComponent', () => {
  let component: SignupheroComponent;
  let fixture: ComponentFixture<SignupheroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupheroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupheroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
