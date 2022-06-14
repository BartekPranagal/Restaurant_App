package com.example.restaurant_app.model.dao.users;

import com.example.restaurant_app.model.dao.order.OrderEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntityWithoutRelations extends UserEntity {

    public UserEntityWithoutRelations(UserEntity entity) {
        this.setId(entity.getId());
        this.setUsername(entity.getUsername());
        this.setPassword(entity.getPassword());
        this.setPhoneNumber(entity.getPhoneNumber());
        this.setMail(entity.getMail());
        this.setName(entity.getName());
        this.setSurname(entity.getSurname());
        this.setStreet(entity.getStreet());
        this.setStreetNumber(entity.getStreetNumber());
        this.setCity(entity.getCity());
        this.setPostalCode(entity.getPostalCode());
        this.setActive(entity.isActive());
        this.setAuthorities(entity.getAuthorities());
        this.setOrderHistory(entity.getOrderHistory());

        this.orderHistoryIds = this.getOrderHistory().stream().map(OrderEntity::getId).collect(Collectors.toList());
        this.authoritiesIds = this.getAuthorities().stream().map(AuthorityEntity::getId).collect(Collectors.toList());
    }

    public UserEntity toUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setId(this.getId());
        entity.setUsername(this.getUsername());
        entity.setPassword(this.getPassword());
        entity.setPhoneNumber(this.getPhoneNumber());
        entity.setMail(this.getMail());
        entity.setName(this.getName());
        entity.setSurname(this.getSurname());
        entity.setStreet(this.getStreet());
        entity.setStreetNumber(this.getStreetNumber());
        entity.setCity(this.getCity());
        entity.setPostalCode(this.getPostalCode());
        entity.setActive(this.isActive());
        entity.setAuthorities(this.getAuthorities());
        entity.setOrderHistory(this.getOrderHistory());
        return entity;
    }

    private List<Long> orderHistoryIds;
    private List<Long> authoritiesIds;

    @Override
    @JsonIgnore
    public List<OrderEntity> getOrderHistory() {
        return super.getOrderHistory();
    }

    @Override
    @JsonIgnore
    public List<AuthorityEntity> getAuthorities() {
        return super.getAuthorities();
    }

}
