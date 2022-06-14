import { Injectable } from '@angular/core';
import {PizzaOrder} from "../models/PizzaOrder";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {LoginService} from "./login.service";

@Injectable({
  providedIn: 'root'
})
export class PizzaOrderService {

  private url = 'http://localhost:8080/api/addOrder'

  orders: PizzaOrder[] = [];
  orderType: string = '';
  orderPrice: number = 0;

  constructor(private httpClient: HttpClient, private loginService: LoginService) {

  }

  sendOrder(): void {
    this.httpClient.post(this.url,{
      "pizzaList": this.orders,
      "orderType": this.orderType,
      "username": this.loginService.username
    },{
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    }).subscribe();
  }
}
