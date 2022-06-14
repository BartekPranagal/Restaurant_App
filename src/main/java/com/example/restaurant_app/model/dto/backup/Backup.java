package com.example.restaurant_app.model.dto.backup;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dao.order.OrderEntity;
import com.example.restaurant_app.model.dao.order.OrderWithoutRelations;
import com.example.restaurant_app.model.dao.order.OrderedPizzaEntity;
import com.example.restaurant_app.model.dao.order.OrderedPizzaEntityWithoutRelations;
import com.example.restaurant_app.model.dao.rating.RatingEntity;
import com.example.restaurant_app.model.dao.users.AuthorityEntity;
import com.example.restaurant_app.model.dao.users.UserEntityWithoutRelations;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Builder
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Backup {

    List<OrderWithoutRelations> orders;
    List<RatingEntity> ratings;
    List<OrderedPizzaEntityWithoutRelations> ordersElements;
    List<AuthorityEntity> authorities;
    List<UserEntityWithoutRelations> users;
    List<PizzaEntity> pizzas;

}
