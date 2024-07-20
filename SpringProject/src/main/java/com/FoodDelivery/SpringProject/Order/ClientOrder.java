package com.FoodDelivery.SpringProject.Order;


import com.FoodDelivery.SpringProject.Food.Food;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @JsonIgnore
//    @OneToMany
//    private List<Food> clientOrder;

    public ClientOrder() {
    }

    public ClientOrder(Long id, String name, List<Food> clientOrder) {
        this.id = id;
        this.name = name;
//        this.clientOrder = clientOrder;
    }

//    public List<Food> getOrder() {
//        return clientOrder;
//    }
//
//    public void setOrder(List<Food> clientOrder) {
//        this.clientOrder = clientOrder;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}