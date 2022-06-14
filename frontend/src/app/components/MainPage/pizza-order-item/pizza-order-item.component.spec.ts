import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaOrderItemComponent } from './pizza-order-item.component';

describe('PizzaOrderItemComponent', () => {
  let component: PizzaOrderItemComponent;
  let fixture: ComponentFixture<PizzaOrderItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PizzaOrderItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzaOrderItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
