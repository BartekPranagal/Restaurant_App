import { Component, OnInit } from '@angular/core';
import {Rating} from "../../../models/Rating";
import {RatingService} from "../../../services/rating.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-rating-list',
  templateUrl: './rating-list.component.html',
  styleUrls: ['./rating-list.component.css']
})
export class RatingListComponent implements OnInit {

  ratings: Rating[] = [];
  pizzaId: number;

  constructor(private ratingService: RatingService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.pizzaId = this.route.snapshot.params['id'];
    this.route.params.subscribe(params => {
      this.pizzaId = params['id'];
    });
    this.ratingService.getRatings(this.pizzaId).subscribe(data => this.ratings = data);
  }

}
