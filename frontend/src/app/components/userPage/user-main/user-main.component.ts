import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../../services/login.service";
import {EditServiceService} from "../../../services/edit-service.service";
import {OrdersService} from "../../../services/orders.service";
import {Order} from "../../../models/Order";
import {User} from "../../../models/User";

@Component({
  selector: 'app-user-main',
  templateUrl: './user-main.component.html',
  styleUrls: ['./user-main.component.css']
})
export class UserMainComponent implements OnInit {

  orders!: Order[];
  user: User;
  constructor(private loginService: LoginService,
              private editService: EditServiceService,
              private orderService: OrdersService) {

    orderService.userOrders().subscribe(data => this.orders = data)
  }

  ngOnInit(): void {
    this.editService.currentUser().subscribe(data => this.user = data);
  }

}
