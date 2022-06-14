package com.example.restaurant_app.model.dao.order;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.aspectj.weaver.ast.Or;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderedPizzaEntityWithoutRelations extends OrderedPizzaEntity {

    public OrderedPizzaEntityWithoutRelations(OrderedPizzaEntity pizzaEntity) {
        this.setPizza(pizzaEntity.getPizza());
        this.setName(pizzaEntity.getName());
        this.setSize(pizzaEntity.getSize());
        this.setPrice(pizzaEntity.getPrice());
        this.setId(pizzaEntity.getId());
        this.pizzaId = pizza.getId();
    }

    public OrderedPizzaEntity toOrderedPizzaEntity(){
        OrderedPizzaEntity entity = new OrderedPizzaEntity();
        entity.setId(this.getId());
        entity.setPizza(this.getPizza());
        entity.setName(this.getName());
        entity.setPrice(this.getPrice());
        entity.setSize(this.getSize());
        return entity;
    }

    private Long pizzaId;

    @Override
    @JsonIgnore
    public PizzaEntity getPizza() {
        return super.getPizza();
    }
}
