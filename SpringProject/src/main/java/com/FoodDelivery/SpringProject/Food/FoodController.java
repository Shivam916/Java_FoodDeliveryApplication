package com.FoodDelivery.SpringProject.Food;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAll(){
        return foodService.getAll();
    }

    @GetMapping("/{id}")
    public Food getById(@PathVariable Long id){
        return  foodService.getById(id);
    }

    @PostMapping("/create")
    public String createFood(@RequestBody Food food){
        foodService.createFood(food);
        return "Successfully Added!";
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id, @RequestBody Food food){
        if(foodService.updateFood(id, food)) return "Successfully Updated!";
        else{
            return "Food not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        if(foodService.deleteById(id)) return "Successfully Deleted!";
        else return "Food not Found!";
    }
}
