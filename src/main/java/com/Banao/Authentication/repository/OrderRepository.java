package com.Banao.Authentication.repository;

import com.Banao.Authentication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
