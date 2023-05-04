package com.SpringBoot.MyString.serviceImpl;

import com.SpringBoot.MyString.entity.Order;
import com.SpringBoot.MyString.repository.OrdersRepository;
import com.SpringBoot.MyString.service.OrdersService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderServiceImpl implements OrdersService {
    private OrdersRepository ordersRepository;
    @Override
    public Order createOrder(Order order) {
        return ordersRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder=ordersRepository.findById(orderId);
        return optionalOrder.get();
    }

    @Override
    public List<Order> getAllOrder() {
        return ordersRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Order order1=ordersRepository.findById(order.getId()).get();
        order1.setOrderName(order.getOrderName());
        order1.setItems(order.getItems());
        Order updatedOrder=ordersRepository.save(order);
        return updatedOrder;
    }

    @Override
    public void deleteOrderById(Long orderId) {

    }
}
