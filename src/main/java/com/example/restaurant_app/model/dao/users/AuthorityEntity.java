package com.example.restaurant_app.model.dao.users;

import com.example.restaurant_app.model.dao.Idenficable;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
public class AuthorityEntity implements Idenficable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
