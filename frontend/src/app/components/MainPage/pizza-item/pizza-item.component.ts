import {Component, Input, OnInit} from '@angular/core';
import {Pizza} from "../../../models/Pizza";
import {CartComponent} from "../cart/cart.component";
import {PizzaOrderService} from "../../../services/pizza-order.service";
import {PizzaOrder} from "../../../models/PizzaOrder";
import {RatingService} from "../../../services/rating.service";
import {LoginService} from "../../../services/login.service";

@Component({
  selector: 'app-pizza-item',
  templateUrl: './pizza-item.component.html',
  styleUrls: ['./pizza-item.component.css']
})
export class PizzaItemComponent implements OnInit {

  @Input()
  public pizza!: Pizza;

  constructor(private pizzaOrderService: PizzaOrderService, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  public addOrderSmall(): void {
    this.pizzaOrderService.orders.push(new PizzaOrder(
      this.pizzaOrderService.orders.length,this.pizza.id,this.pizza.name,"small",this.pizza.smallPrice))
    this.countOrderPrice();
  }
  public addOrderMedium(): void {
    this.pizzaOrderService.orders.push(new PizzaOrder(
      this.pizzaOrderService.orders.length,this.pizza.id,this.pizza.name,"medium",this.pizza.mediumPrice))
    this.countOrderPrice();
  }
  public addOrderLarge(): void {
    this.pizzaOrderService.orders.push(new PizzaOrder(
      this.pizzaOrderService.orders.length,this.pizza.id,this.pizza.name,"big",this.pizza.bigPrice))
    this.countOrderPrice();
  }
  public countOrderPrice(): void {
    let price: number = 0;
    this.pizzaOrderService.orders.forEach(x => price += x.price)
    const date = new Date()
    if(date.getDay() == 2) {
      this.pizzaOrderService.orderPrice = price - (price * .20);
    }else if (date.getDay() == 4) {
      this.pizzaOrderService.orderPrice = price - (price * .10);
    } else {
      this.pizzaOrderService.orderPrice = price;
    }

  }

  public isLoggedIn(): boolean {
    return this.loginService.loggedIn
  }

}
