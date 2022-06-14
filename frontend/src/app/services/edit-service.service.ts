import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class EditServiceService {

  private url = 'http://localhost:8080/api/editUser/'
  private _id = 0;

  constructor(private httpClient: HttpClient, private router: Router,) { }

  edit(username: String, password: String, phoneNumber: String, mail: String, name: String,
           surname: String, street: String, streetNumber: String, city: String, postalCode: String): void {


    this.url = 'http://localhost:8080/api/editUser/' + this._id;

    this.httpClient.put(this.url, {
      "username": username,
      "password": password,
      "phoneNumber": phoneNumber,
      "mail": mail,
      "name": name,
      "surname": surname,
      "street": street,
      "streetNumber": streetNumber,
      "city": city,
      "postalCode": postalCode
    } , HTTP_OPTIONS).subscribe(resp => {
      this.router.navigate([''])
    });
  }


  set id(value: number) {
    this._id = value;
  }
}
