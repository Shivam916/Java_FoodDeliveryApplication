package com.FoodDelivery.SpringProject.Order;

import java.util.List;

public interface OrderService {
    List<ClientOrder> getAll();
    ClientOrder getById(Long id);
    void createOrder(ClientOrder order);

}
