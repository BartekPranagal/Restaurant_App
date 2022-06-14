import { Component, OnInit } from '@angular/core';
import {RegisterServiceService} from "../../../services/register-service.service";

@Component({
  selector: 'app-register-main',
  templateUrl: './register-main.component.html',
  styleUrls: ['./register-main.component.css']
})
export class RegisterMainComponent implements OnInit {

  constructor(private registerService: RegisterServiceService) { }

  ngOnInit(): void {
  }

  register(username: String, password: String, phoneNumber: String, mail: String, name: String,
           surname: String, street: String, streetNumber: String, city: String, postalCode: String): void {
    this.registerService.register(username,password,phoneNumber,mail,name,surname,street,streetNumber,city,postalCode)

  }

}
