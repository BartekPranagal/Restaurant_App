export class PizzaOrder {
  arrid!: number;
  pizzaId!: number;
  name!: string;
  size!: string;
  price!: number;


  constructor(arrid: number,id: number, name: string, size: string, price: number) {
    this.arrid = arrid;
    this.pizzaId = id;
    this.name = name;
    this.size = size;
    this.price = price;
  }
}
