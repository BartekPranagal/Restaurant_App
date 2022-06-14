import {Component, Input, OnInit} from '@angular/core';
import {PizzaOrder} from "../../../models/PizzaOrder";
import {PizzaOrderService} from "../../../services/pizza-order.service";

@Component({
  selector: 'app-pizza-order-item',
  templateUrl: './pizza-order-item.component.html',
  styleUrls: ['./pizza-order-item.component.css']
})
export class PizzaOrderItemComponent implements OnInit {

  @Input()
  public pizzaOrder!: PizzaOrder;

  constructor(private pizzaOrderService: PizzaOrderService) { }

  ngOnInit(): void {
  }

  public deleteOrder(): void {
    let number = this.pizzaOrder.arrid
      this.pizzaOrderService.orders.splice(this.pizzaOrder.arrid, 1)
    this.pizzaOrderService.orders.forEach(value => {
      if (value.arrid > number){
        value.arrid -= 1;
      }
    } )
    this.countOrderPrice();
  }

  public countOrderPrice(): void {
    let price: number = 0;
    this.pizzaOrderService.orders.forEach(x => price += x.price)
    this.pizzaOrderService.orderPrice = price;
  }

}
