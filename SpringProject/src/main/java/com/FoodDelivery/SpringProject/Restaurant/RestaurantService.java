package com.FoodDelivery.SpringProject.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();

    void createRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(Long Id);

    boolean deleteRestaurantById(Long id);

    boolean updateRestaurant(Long id, Restaurant newRes);
}
