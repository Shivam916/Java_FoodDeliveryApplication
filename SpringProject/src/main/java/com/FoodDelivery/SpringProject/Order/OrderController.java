package com.FoodDelivery.SpringProject.Order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<ClientOrder> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public ClientOrder getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody ClientOrder order){
        orderService.createOrder(order);
        return "Order Placed!";
    }
}
