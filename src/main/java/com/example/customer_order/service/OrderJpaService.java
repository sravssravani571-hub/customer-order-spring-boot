package com.example.customer_order.service;

import com.example.customer_order.model.Customer;
import com.example.customer_order.model.Order;
import com.example.customer_order.repository.OrderJpaRepository;
import com.example.customer_order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderJpaService implements OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Override
    public ArrayList<Order> getOrders() {
        List<Order> orderList = orderJpaRepository.findAll();
        return new ArrayList<>(orderList);
    }

    @Override
    public Order getOrderById(int orderId) {
        try {
            return orderJpaRepository.findById(orderId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Order addOrder(Order order) {
        return orderJpaRepository.save(order);
    }

    @Override
    public Order updateOrder(int orderId, Order order) {
        try {
            Order newOrder = orderJpaRepository.findById(orderId).get();

            if (order.getProductName() != null) {
                newOrder.setProductName(order.getProductName());
            }

            if (order.getQuantity() != 0) {
                newOrder.setQuantity(order.getQuantity());
            }

            if (order.getCustomer() != null) {
                newOrder.setCustomer(order.getCustomer());
            }

            return orderJpaRepository.save(newOrder);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try {
            orderJpaRepository.deleteById(orderId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Customer getOrderCustomer(int orderId) {
        try {
            Order order = orderJpaRepository.findById(orderId).get();
            return order.getCustomer();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}