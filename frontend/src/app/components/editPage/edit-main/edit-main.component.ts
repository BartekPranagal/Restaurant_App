import { Component, OnInit } from '@angular/core';
import {EditServiceService} from "../../../services/edit-service.service";

@Component({
  selector: 'app-edit-main',
  templateUrl: './edit-main.component.html',
  styleUrls: ['./edit-main.component.css']
})
export class EditMainComponent implements OnInit {

  constructor(private editService: EditServiceService) { }

  ngOnInit(): void {
  }

  edit(username: String, password: String, phoneNumber: String, mail: String, name: String,
           surname: String, street: String, streetNumber: String, city: String, postalCode: String): void {
    this.editService.edit(username,password,phoneNumber,mail,name,surname,street,streetNumber,city,postalCode)

  }

}
