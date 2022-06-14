import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable,} from "rxjs";
import {Pizza} from "../models/Pizza";

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})

export class PizzaService {

  private _query: String = ''

  private menuUrl = 'http://localhost:8080/api/menu?query=' + this._query;

  constructor(private httpClient: HttpClient) {
  }

  public getMenu(): Observable<Pizza[]> {
    this.menuUrl = 'http://localhost:8080/api/menu?query=' + this._query;
    return this.httpClient.get<Pizza[]>(`${this.menuUrl}`, HTTP_OPTIONS)
  }


  get query(): String {
    return this._query;
  }

  set query(value: String) {
    this._query = value;
  }
}
