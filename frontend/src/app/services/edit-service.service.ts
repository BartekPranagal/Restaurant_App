import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {LoginService} from "./login.service";
import {User} from "../models/User";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EditServiceService {

  private url = 'http://localhost:8080/api/users';

  constructor(private httpClient: HttpClient,
              private router: Router,
              private loginService: LoginService) {
  }

  edit(userId, username: String, password: String, phoneNumber: String, mail: String, name: String,
       surname: String, street: String, streetNumber: String, city: String, postalCode: String): void {
    let editUserUrl = this.url + "/" + userId;

    this.httpClient.put(editUserUrl, {
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
    }, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    })
      .subscribe(resp => {
        this.router.navigate([''])
      });
  }

  currentUser(): Observable<User> {
    return this.httpClient.get<User>(this.url + '/current', {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    });
  }

  delete(userId: any): void {
    this.httpClient.delete<void>(this.url + "/" + userId, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    }).subscribe(resp => {
      this.router.navigate([''])
    });

  }
}
