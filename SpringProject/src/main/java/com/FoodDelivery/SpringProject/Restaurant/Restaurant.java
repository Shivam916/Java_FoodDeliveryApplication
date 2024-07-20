package com.FoodDelivery.SpringProject.Restaurant;

import com.FoodDelivery.SpringProject.Menu.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long rating;
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;
    public Restaurant() {
    }

    public Restaurant(Long id, String name, Long rating, String location, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.location = location;
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
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

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
