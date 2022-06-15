import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../../services/login.service";
import {EditServiceService} from "../../../services/edit-service.service";
import {OrdersService} from "../../../services/orders.service";
import {Order} from "../../../models/Order";

@Component({
  selector: 'app-user-main',
  templateUrl: './user-main.component.html',
  styleUrls: ['./user-main.component.css']
})
export class UserMainComponent implements OnInit {

  orders!: Order[];

  constructor(private loginService: LoginService, private editService: EditServiceService,
              private orderService: OrdersService) {

    orderService.userOrders().subscribe(data => this.orders = data)


  }

  ngOnInit(): void {
  }

}
