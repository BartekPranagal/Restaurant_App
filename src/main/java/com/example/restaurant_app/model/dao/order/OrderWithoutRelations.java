package com.example.restaurant_app.model.dao.order;

import com.example.restaurant_app.model.dao.users.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderWithoutRelations extends OrderEntity {

    public OrderWithoutRelations(OrderEntity orderEntity) {
        super(orderEntity.getId(),
                orderEntity.getDeliveryType(),
                orderEntity.getName(),
                orderEntity.getSurname(),
                orderEntity.getStreet(),
                orderEntity.getStreetNumber(),
                orderEntity.getCity(),
                orderEntity.getPostalCode(),
                orderEntity.getPhoneNumber(),
                orderEntity.getPrice(),
                orderEntity.getOrderedPizzas(),
                orderEntity.getUser());

        this.orderedPizzasId = super.getOrderedPizzas().stream().map(OrderedPizzaEntity::getId).collect(Collectors.toList());
        this.userId = super.getUser().getId();
    }

    public OrderEntity toOrderEntity(){
        return new OrderEntity(this.getId(),
              this.getDeliveryType(),
              this.getName(),
              this.getSurname(),
              this.getStreet(),
              this.getStreetNumber(),
              this.getCity(),
              this.getPostalCode(),
              this.getPhoneNumber(),
              this.getPrice(),
              this.getOrderedPizzas(),
              this.getUser());
    }

    private List<Long> orderedPizzasId;
    private Long userId;

    @Override
    @JsonIgnore
    public List<OrderedPizzaEntity> getOrderedPizzas() {
        return super.getOrderedPizzas();
    }

    @Override
    @JsonIgnore
    public UserEntity getUser() {
        return super.getUser();
    }
}
