import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoginService} from "./login.service";
import {Order} from "../models/Order";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private url = 'http://localhost:8080/api/orders'

  private urlAll = 'http://localhost:8080/api/allOrders'

  constructor(private httpClient: HttpClient, private loginService: LoginService) { }

  userOrders(): Observable<Order[]> {

    return this.httpClient.get<Order[]>(this.url, {
      headers : new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    })
  }

  allOrders(): Observable<Order[]> {

    return this.httpClient.get<Order[]>(this.urlAll, {
      headers : new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    })
  }
}
