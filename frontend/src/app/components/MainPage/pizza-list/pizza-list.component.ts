import {Component, OnInit} from '@angular/core';
import {Pizza} from "../../../models/Pizza";
import {PizzaService} from 'src/app/services/pizza.service';

@Component({
  selector: 'app-pizza-list',
  templateUrl: './pizza-list.component.html',
  styleUrls: ['./pizza-list.component.css']
})
export class PizzaListComponent implements OnInit {

  menu: Pizza[] = [];

  constructor(private pizzaService: PizzaService) {
    this.pizzaService.getMenu().subscribe(data => this.menu = data);
  }

  public updateMenu(query: String): void {
    this.pizzaService.query = query
    this.pizzaService.getMenu().subscribe(data => this.menu = data,);
  }

  ngOnInit(): void {
  }
}
