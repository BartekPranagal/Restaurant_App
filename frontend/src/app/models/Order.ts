import {PizzaOrder} from "./PizzaOrder";

export class Order {
  name!: string;
  surname!: string;
  deliveryType!: string;
  street!:string;
  streetNumber!: number;
  city!: string;
  postalCode!: number;
  phoneNumber!: string;
  price!: number;
  orderedPizzas!: PizzaOrder[];

}
