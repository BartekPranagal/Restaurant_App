import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../../services/login.service";
import {RatingService} from "../../../services/rating.service";

@Component({
  selector: 'app-rating-main',
  templateUrl: './rating-main.component.html',
  styleUrls: ['./rating-main.component.css']
})
export class RatingMainComponent implements OnInit {

  selectedValue!: number;

  grades: number[] = [1,2,3,4,5];

  constructor(private loginService: LoginService, private ratingService: RatingService) { }

  ngOnInit(): void {
  }

  public updateRating(content: String): void {
    this.ratingService.grade = this.selectedValue;
    this.ratingService.content = content;
    this.ratingService.sendRating();
  }

  public isLoggedIn(): boolean {
    return this.loginService.loggedIn;
  }

}
