package com.SpringBoot.MyString.repository;


import com.SpringBoot.MyString.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
