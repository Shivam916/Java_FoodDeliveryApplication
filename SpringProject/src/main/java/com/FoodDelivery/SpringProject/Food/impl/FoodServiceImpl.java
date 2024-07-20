package com.FoodDelivery.SpringProject.Food.impl;

import com.FoodDelivery.SpringProject.Food.Food;
import com.FoodDelivery.SpringProject.Food.FoodRepository;
import com.FoodDelivery.SpringProject.Food.FoodService;
import com.FoodDelivery.SpringProject.Menu.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food getById(Long id) {
//        if(foodRepository.existsById(id)){
//            Optional<Food> returnFood= foodRepository.findById(id);
//            return returnFood.get();
//        }
//        return null;

        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public void createFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public boolean updateFood(Long id, Food food) {
        Optional<Food> foodOptional = foodRepository.findById(id);
        if(foodOptional.isPresent()){
            Food f = foodOptional.get();
            f.setName(food.getName());
            f.setPrice(food.getPrice());
            f.setMenu(food.getMenu());
            foodRepository.save(f);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if(foodRepository.existsById(id)){
            foodRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
