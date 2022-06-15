import { Component, OnInit } from '@angular/core';
import {EditServiceService} from "../../../services/edit-service.service";
import {User} from "../../../models/User";
import {LoginService} from "../../../services/login.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-edit-main',
  templateUrl: './edit-main.component.html',
  styleUrls: ['./edit-main.component.css']
})
export class EditMainComponent implements OnInit {

  constructor(private userService: EditServiceService,
              private route: ActivatedRoute) { }

  private userId;

  ngOnInit(): void {
    console.log(this.route);
    this.userId = this.route.snapshot.params['id'];
    console.log(this.userId);
    if(this.userId == null){
      this.userService.currentUser().subscribe(user => this.userId = user.id);
    }

    this.route.params.subscribe(params => {
      this.userId = params['id'];
      if(this.userId == null){
        this.userService.currentUser().subscribe(user => this.userId = user.id);
      }
    });
  }

  edit(username: String, password: String, phoneNumber: String, mail: String, name: String,
           surname: String, street: String, streetNumber: String, city: String, postalCode: String): void {
    this.userService.edit(this.userId, username,password,phoneNumber,mail,name,surname,street,streetNumber,city,postalCode)

  }

  delete() {
    this.userService.delete(this.userId);
  }
}
