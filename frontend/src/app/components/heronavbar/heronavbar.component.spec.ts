import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeronavbarComponent } from './heronavbar.component';

describe('HeronavbarComponent', () => {
  let component: HeronavbarComponent;
  let fixture: ComponentFixture<HeronavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeronavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeronavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
