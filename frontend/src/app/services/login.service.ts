import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {JwtHelperService} from "@auth0/angular-jwt";
import {User} from "../models/User";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = 'http://localhost:8080/login'

  private usersUrl = 'http://localhost:8080/api/users'

  private helper = new JwtHelperService();

  private _userId: number = 0;
  private _username: String = '';
  private password: String = '';
  private body: String = '';
  private _token: any = '';
  private _loggedIn: boolean = false;
  private _authorities: String[] = []

  constructor(private httpClient: HttpClient, private router: Router,) {

  }

  logIn(username: String, password: String): void {

    this._username = username;
    this.password = password;
    this.body = 'username=' + this._username + '&password=' + this.password;

    this.httpClient.post<any>(this.loginUrl, this.body, {
      headers: new HttpHeaders({
        'Content-Type': 'application/x-www-form-urlencoded',
      }),
      observe: "response"
    }).subscribe(resp => {
      this._token = resp.headers.get('Authorization');
      this.router.navigate([''])
      this._loggedIn = true;
      this._authorities = this.helper.decodeToken(this.token).authorities
      this._userId = this.helper.decodeToken(this.token).id
    });
  }

  users(): Observable<User[]> {

    return this.httpClient.get<User[]>(this.usersUrl, {
      headers : new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.token
      })
    })
  }


  get token(): any {
    return this._token;
  }

  get loggedIn(): boolean {
    return this._loggedIn;
  }

  get username(): String {
    return this._username;
  }


  get authorities(): String[] {
    return this._authorities;
  }


  get userId(): number {
    return this._userId;
  }
}
