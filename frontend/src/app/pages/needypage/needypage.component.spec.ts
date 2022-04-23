import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedypageComponent } from './needypage.component';

describe('NeedypageComponent', () => {
  let component: NeedypageComponent;
  let fixture: ComponentFixture<NeedypageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeedypageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedypageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
