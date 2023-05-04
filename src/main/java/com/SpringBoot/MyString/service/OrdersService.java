package com.SpringBoot.MyString.service;

import com.SpringBoot.MyString.entity.Order;

import java.util.List;

public interface OrdersService {
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    List<Order> getAllOrder();
    Order updateOrder(Order order);
    void deleteOrderById(Long orderId);
}
