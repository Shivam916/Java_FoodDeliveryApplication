package com.FoodDelivery.SpringProject.Food;

import com.FoodDelivery.SpringProject.Menu.Menu;
//import com.FoodDelivery.SpringProject.Order.ClientOrder;
import jakarta.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;

    @ManyToOne
    private Menu menu;

//    @ManyToOne
//    private ClientOrder clientOrder;
//    gjhgjgkj
    int abc= 0;

    public Food() {
    }

    public Food(Long id, String name, Long price, Menu menu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.menu = menu;
//        this.clientOrder = clientOrder;
    }

//    public ClientOrder getOrder() {
//        return clientOrder;
//    }
//
//    public void setOrder(ClientOrder clientOrder) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
