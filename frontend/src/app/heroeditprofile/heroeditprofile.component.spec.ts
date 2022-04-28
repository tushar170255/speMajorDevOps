import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroeditprofileComponent } from './heroeditprofile.component';

describe('HeroeditprofileComponent', () => {
  let component: HeroeditprofileComponent;
  let fixture: ComponentFixture<HeroeditprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeroeditprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeroeditprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
