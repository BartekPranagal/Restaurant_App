import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopBarRatingComponent } from './top-bar-rating.component';

describe('TopBarRatingComponent', () => {
  let component: TopBarRatingComponent;
  let fixture: ComponentFixture<TopBarRatingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopBarRatingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopBarRatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
