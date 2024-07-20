package com.FoodDelivery.SpringProject.Order.impl;

import com.FoodDelivery.SpringProject.Order.ClientOrder;
import com.FoodDelivery.SpringProject.Order.OrderRepository;
import com.FoodDelivery.SpringProject.Order.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceIml implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceIml(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<ClientOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public ClientOrder getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void createOrder(ClientOrder order) {
        orderRepository.save(order);
    }
}
