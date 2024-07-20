package com.FoodDelivery.SpringProject.Restaurant.impl;

import com.FoodDelivery.SpringProject.Restaurant.Restaurant;
import com.FoodDelivery.SpringProject.Restaurant.RestaurantRepository;
import com.FoodDelivery.SpringProject.Restaurant.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService {
//    List<Restaurant> restaurants = new ArrayList<>();
     RestaurantRepository restaurantRepository;

    public RestaurantServiceImp(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long Id) {
        return restaurantRepository.findById(Id).orElse(null);
    }

    @Override
    public boolean deleteRestaurantById(Long id) {
        if(restaurantRepository.existsById(id)){
            restaurantRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateRestaurant(Long id, Restaurant newRes) {
        Optional<Restaurant> restOptional = restaurantRepository.findById(id);
        if(restOptional.isPresent()){
            Restaurant r = restOptional.get();
            r.setName(newRes.getName());
            r.setRating(newRes.getRating());
            r.setLocation(newRes.getLocation());
            r.setMenus(newRes.getMenus());
            restaurantRepository.save(r);
            return true;
        }
        return false;
    }

}
