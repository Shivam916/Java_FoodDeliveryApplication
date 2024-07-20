package com.FoodDelivery.SpringProject.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ClientOrder, Long> {
}
