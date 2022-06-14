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
}

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  private pizzaId = 0;
  private _grade = 0;
  private _content: String = '';

  private ratingGetUrl = 'http://localhost:8080/api/getPizzaRating'
  private ratingPostUrl = 'http://localhost:8080/api/addRating'

  constructor(private httpClient: HttpClient, @Inject(DOCUMENT)private document: Document,
              private loginService: LoginService) {
  }

  public getRatings(): Observable<Rating[]> {
    let url = this.document.location.href
    this.pizzaId = Number(url.substring(29))
    this.ratingGetUrl = 'http://localhost:8080/api/getPizzaRating/' + this.pizzaId
    return this.httpClient.get<Rating[]>(`${this.ratingGetUrl}`, HTTP_OPTIONS)
  }

  sendRating(): void {
    this.httpClient.post(this.ratingPostUrl,{
      "pizzaId": this.pizzaId,
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
