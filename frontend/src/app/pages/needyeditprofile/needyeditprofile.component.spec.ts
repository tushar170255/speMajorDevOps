import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedyeditprofileComponent } from './needyeditprofile.component';

describe('NeedyeditprofileComponent', () => {
  let component: NeedyeditprofileComponent;
  let fixture: ComponentFixture<NeedyeditprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeedyeditprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedyeditprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
