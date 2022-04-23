import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedynavbarComponent } from './needynavbar.component';

describe('NeedynavbarComponent', () => {
  let component: NeedynavbarComponent;
  let fixture: ComponentFixture<NeedynavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeedynavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedynavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
