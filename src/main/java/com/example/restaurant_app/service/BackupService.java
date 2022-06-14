package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dto.backup.Backup;
import com.example.restaurant_app.model.dao.Idenficable;
import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dao.order.OrderEntity;
import com.example.restaurant_app.model.dao.order.OrderWithoutRelations;
import com.example.restaurant_app.model.dao.order.OrderedPizzaEntity;
import com.example.restaurant_app.model.dao.order.OrderedPizzaEntityWithoutRelations;
import com.example.restaurant_app.model.dao.rating.RatingEntity;
import com.example.restaurant_app.model.dao.users.AuthorityEntity;
import com.example.restaurant_app.model.dao.users.UserEntity;
import com.example.restaurant_app.model.dao.users.UserEntityWithoutRelations;
import com.example.restaurant_app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BackupService {

    private final OrderRepository orderRepository;
    private final AuthorityRepository authorityRepository;
    private final PizzaRepository pizzaRepository;
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final OrderElementRepository orderElementsRepository;

    public Backup getFullBackup() {
        return Backup.builder()
                .orders(orderRepository.findAll().stream().map(OrderWithoutRelations::new).collect(Collectors.toList()))
                .authorities(authorityRepository.findAll())
                .ordersElements(orderElementsRepository.findAll().stream().map(OrderedPizzaEntityWithoutRelations::new).collect(Collectors.toList()))
                .pizzas(pizzaRepository.findAll())
                .ratings(ratingRepository.findAll())
                .users(userRepository.findAll().stream().map(UserEntityWithoutRelations::new).collect(Collectors.toList()))
                .build();
    }

    public void uploadBackup(Backup backup) {
        orderRepository.deleteAll();
        userRepository.deleteAll();
        pizzaRepository.deleteAll();
        ratingRepository.deleteAll();


        MigrationElement<AuthorityEntity> authorities = new MigrationElement<>();
        backup.getAuthorities().forEach(x -> authorities.saveElement(x, authorityRepository));

        MigrationElement<UserEntity> users = new MigrationElement<>();
        backup.getUsers().stream()
                .peek(x -> x.setAuthorities(x.getAuthoritiesIds().stream().map(id -> authorityRepository.getById(authorities.getNewId(id))).collect(Collectors.toList())))
                .map(UserEntityWithoutRelations::toUserEntity)
                .forEach(x -> users.saveElement(x, userRepository));

        MigrationElement<PizzaEntity> pizzas = new MigrationElement<>();
        backup.getPizzas().forEach(x -> pizzas.saveElement(x, pizzaRepository));

        MigrationElement<RatingEntity> ratings = new MigrationElement<>();
        backup.getRatings().forEach(x -> ratings.saveElement(x, ratingRepository));

        MigrationElement<OrderedPizzaEntity> pizzaOrderElements = new MigrationElement<>();
        backup.getOrdersElements().stream().peek(x -> x.setPizza(pizzaRepository.getById(pizzas.getNewId(x.getPizzaId()))))
                .map(OrderedPizzaEntityWithoutRelations::toOrderedPizzaEntity)
                .forEach(x -> pizzaOrderElements.saveElement(x, orderElementsRepository));

        MigrationElement<OrderEntity> orders = new MigrationElement<>();
        backup.getOrders().stream()
                .peek(x -> x.setUser(userRepository.getById(users.getNewId(x.getUserId()))))
                .peek(x -> x.setOrderedPizzas(x.getOrderedPizzasId().stream()
                        .map(id -> orderElementsRepository.getById(pizzaOrderElements.getNewId(id)))
                        .collect(Collectors.toList())))
                .map(OrderWithoutRelations::toOrderEntity)
                .forEach(x -> orders.saveElement(x, orderRepository));

    }

    class MigrationElement <ELEMENT extends Idenficable> {
        Map<Long, ELEMENT> oldIds = new HashMap<>();
        Map<ELEMENT, Long> newIds = new HashMap<>();

        Long getNewId(Long oldId){
            ELEMENT element = oldIds.get(oldId);
            return newIds.get(element);
        }

        void saveElement(ELEMENT element, JpaRepository<ELEMENT, Long> repository){
            ELEMENT newElement = repository.save(element);
            oldIds.put(element.getId(), newElement);
            newIds.put(newElement, newElement.getId());
        }
    }
}
