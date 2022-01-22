package com.example.restaurant_app.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Pizza")
@Data
public class PizzaEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "small_price")
    private Float smallPrice;

    @Column(name = "medium_price")
    private Float mediumPrice;

    @Column(name = "big_price")
    private Float bigPrice;

    @Column(name = "Sale")
    private Boolean isOnSale;

    @Column(name = "Vege")
    private  Boolean isVege;

    public float getPriceBySize(String size){
        float price= 0.0F;

        if(size.toLowerCase().equals("small"))
            price=getSmallPrice();
        else if(size.toLowerCase().equals("medium"))
            price=getMediumPrice();
        else if (size.toLowerCase().equals("large"))
            price=getBigPrice();
        else
            System.out.println("coś tu poszło nie tak");

        return price;
    }
}
