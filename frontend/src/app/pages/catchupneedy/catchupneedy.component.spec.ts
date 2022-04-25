import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatchupneedyComponent } from './catchupneedy.component';

describe('CatchupneedyComponent', () => {
  let component: CatchupneedyComponent;
  let fixture: ComponentFixture<CatchupneedyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CatchupneedyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CatchupneedyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
