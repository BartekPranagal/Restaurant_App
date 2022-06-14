import {Component, Input, OnInit} from '@angular/core';
import {Rating} from "../../../models/Rating";

@Component({
  selector: 'app-rating-item',
  templateUrl: './rating-item.component.html',
  styleUrls: ['./rating-item.component.css']
})
export class RatingItemComponent implements OnInit {

  @Input()
  public rating!: Rating;

  constructor() { }

  ngOnInit(): void {
  }

}
