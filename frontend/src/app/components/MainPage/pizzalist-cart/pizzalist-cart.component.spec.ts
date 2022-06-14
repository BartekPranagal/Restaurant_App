import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzalistCartComponent } from './pizzalist-cart.component';

describe('PizzalistCartComponent', () => {
  let component: PizzalistCartComponent;
  let fixture: ComponentFixture<PizzalistCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PizzalistCartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzalistCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
