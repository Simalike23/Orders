package com.SpringBoot.MyString.controller;

import com.SpringBoot.MyString.entity.Order;
import com.SpringBoot.MyString.service.OrdersService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {
    private OrdersService ordersService;
    //build create orders rest api

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order myorder=ordersService.createOrder(order);
        return  new ResponseEntity<>(myorder, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId){
        Order myorder2=ordersService.getOrderById(orderId);
        return new ResponseEntity<>(myorder2,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> myorder3=ordersService.getAllOrder();
        return new ResponseEntity<>(myorder3, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("id") Long orderId){
        order.setId(orderId);
        Order updatedOrder=ordersService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId){
        ordersService.deleteOrderById(orderId);
        return new ResponseEntity<>("Order deleted" ,HttpStatus.OK);
    }
}
