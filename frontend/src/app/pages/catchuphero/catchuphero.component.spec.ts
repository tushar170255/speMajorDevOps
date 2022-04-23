import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatchupheroComponent } from './catchuphero.component';

describe('CatchupheroComponent', () => {
  let component: CatchupheroComponent;
  let fixture: ComponentFixture<CatchupheroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CatchupheroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CatchupheroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
