package com.FoodDelivery.SpringProject.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAll();
    Food getById(Long id);
    void createFood(Food food);
    boolean updateFood(Long id, Food food);
    boolean deleteById(Long id);
}
