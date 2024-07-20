package com.FoodDelivery.SpringProject.Restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantService restaurantservice;

    public RestaurantController(RestaurantService restaurantservice) {
        this.restaurantservice = restaurantservice;
    }

    @GetMapping("")
    public List<Restaurant> getAll(){
        return restaurantservice.findAll();
    }

    @PostMapping("/create")
    public String createRestaurant(@RequestBody Restaurant restaurant){
        restaurantservice.createRestaurant(restaurant);
        return "Restaurant Successfully Added!";
    }

    @GetMapping("/{Id}")
    public Restaurant getRestaurantById(@PathVariable("Id") Long Id){
        Restaurant val =  restaurantservice.getRestaurantById(Id);
        if(val != null){
            return val;
        }
        return new Restaurant();
    }

    @DeleteMapping("/{Id}")
    public String deleteRestaurantById(@PathVariable("Id") Long id){
        boolean reply = restaurantservice.deleteRestaurantById(id);
        return reply==true?"Successfully Deleted!": "Restaurant Not Found";
    }

    @PutMapping("/{Id}")
    public String updateRestaurant(@PathVariable("Id") Long id,
                                   @RequestBody Restaurant newRes){
        boolean reply = restaurantservice.updateRestaurant(id, newRes);
        if(reply){
            return "Successfully Updated!";
        }
        else{
            return "Restaurant Not Found";
        }
    }
}
