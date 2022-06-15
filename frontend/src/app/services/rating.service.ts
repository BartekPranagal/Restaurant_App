import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rating} from "../models/Rating";
import {DOCUMENT} from "@angular/common";
import {LoginService} from "./login.service";

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  private _grade = 0;
  private _content: String = '';

  private url = 'http://localhost:8080/api/pizza-ratings';

  constructor(private httpClient: HttpClient, @Inject(DOCUMENT)private document: Document,
              private loginService: LoginService) {
  }

  public getRatings(pizzaId: number): Observable<Rating[]> {
    let ratingsUrl = 'http://localhost:8080/api/pizzas/' + pizzaId + '/ratings';
    return this.httpClient.get<Rating[]>(ratingsUrl, HTTP_OPTIONS)
  }

  sendRating(pizzaId): void {
    this.httpClient.post(this.url,{
      "pizzaId": pizzaId,
      "grade": this._grade,
      "content": this._content,
      "user": this.loginService.username
    },{
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.loginService.token
      })
    }).subscribe();
  }


  set grade(value: number) {
    this._grade = value;
  }

  set content(value: String) {
    this._content = value;
  }
}
