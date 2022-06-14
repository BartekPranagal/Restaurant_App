import {Component, OnInit} from '@angular/core';
import {PizzaOrder} from "../../../models/PizzaOrder";
import {PizzaOrderService} from "../../../services/pizza-order.service";
import {LoginService} from "../../../services/login.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  orders: PizzaOrder[] = this.pizzaOrderService.orders;

  constructor(private pizzaOrderService: PizzaOrderService, private loginService: LoginService) {
  }

  ngOnInit(): void {
  }

  public changeOrderType(x: string): void {
    this.pizzaOrderService.orderType = x;
  }

  public checkPrice(): number {
    return Math.round(this.pizzaOrderService.orderPrice * 100) / 100
  }

  public endOrder(): void {
    this.pizzaOrderService.sendOrder()
  }

  public isLoggedIn(): boolean {
    return this.loginService.loggedIn
  }
}
