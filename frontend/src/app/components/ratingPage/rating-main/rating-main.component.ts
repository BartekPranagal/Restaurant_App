import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../../services/login.service";
import {RatingService} from "../../../services/rating.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-rating-main',
  templateUrl: './rating-main.component.html',
  styleUrls: ['./rating-main.component.css']
})
export class RatingMainComponent implements OnInit {

  selectedValue!: number;
  grades: number[] = [1,2,3,4,5];
  pizzaId;

  constructor(private loginService: LoginService, private ratingService: RatingService, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.pizzaId = this.route.snapshot.params['id'];

    this.route.params.subscribe(params => {
      this.pizzaId = params['id'];
    });
  }

  public updateRating(content: String): void {
    this.ratingService.grade = this.selectedValue;
    this.ratingService.content = content;
    this.ratingService.sendRating(this.pizzaId);
  }

  public isLoggedIn(): boolean {
    return this.loginService.loggedIn;
  }

}
