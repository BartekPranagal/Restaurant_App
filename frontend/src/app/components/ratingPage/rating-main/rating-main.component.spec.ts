import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingMainComponent } from './rating-main.component';

describe('RatingMainComponent', () => {
  let component: RatingMainComponent;
  let fixture: ComponentFixture<RatingMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RatingMainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
