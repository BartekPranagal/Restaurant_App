import { Component, OnInit } from '@angular/core';
import {Rating} from "../../../models/Rating";
import {RatingService} from "../../../services/rating.service";

@Component({
  selector: 'app-rating-list',
  templateUrl: './rating-list.component.html',
  styleUrls: ['./rating-list.component.css']
})
export class RatingListComponent implements OnInit {

  ratings: Rating[] = [];

  constructor(private ratingService: RatingService) {
    this.ratingService.getRatings().subscribe(data => this.ratings = data);
  }

  ngOnInit(): void {
  }

}
