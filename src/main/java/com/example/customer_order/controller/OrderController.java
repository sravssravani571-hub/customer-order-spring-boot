
package com.example.customer_order.controller;

import com.example.customer_order.model.Customer;
import com.example.customer_order.model.Order;
import com.example.customer_order.service.OrderJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OrderController {

    @Autowired
    private OrderJpaService orderJpaService;

    @GetMapping("/orders")
    public ArrayList<Order> getOrders() {
        return orderJpaService.getOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrderById(
            @PathVariable("orderId") int orderId) {
        return orderJpaService.getOrderById(orderId);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderJpaService.addOrder(order);
    }

    @PutMapping("/orders/{orderId}")
    public Order updateOrder(
            @PathVariable("orderId") int orderId,
            @RequestBody Order order) {
        return orderJpaService.updateOrder(orderId, order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(
            @PathVariable("orderId") int orderId) {
        orderJpaService.deleteOrder(orderId);
    }

    @GetMapping("/orders/{orderId}/customer")
    public Customer getOrderCustomer(
            @PathVariable("orderId") int orderId) {
        return orderJpaService.getOrderCustomer(orderId);
    }
}
