package com.FoodDelivery.SpringProject.Menu;

import com.FoodDelivery.SpringProject.Food.Food;
import com.FoodDelivery.SpringProject.Restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Restaurant restaurant;

    //food ( many to many relation)
    @JsonIgnore
    @OneToMany
    private List<Food> food;



    public Menu(Long id, String name, Restaurant restaurant, List<Food> food) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.food = food;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

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

    public Menu() {
    }

}
