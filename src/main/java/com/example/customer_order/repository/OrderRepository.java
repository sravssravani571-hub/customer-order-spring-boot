package com.example.customer_order.repository;

import com.example.customer_order.model.Customer;
import com.example.customer_order.model.Order;

import java.util.ArrayList;

public interface OrderRepository {

    ArrayList<Order> getOrders();

    Order getOrderById(int orderId);

    Order addOrder(Order order);

    Order updateOrder(int orderId, Order order);

    void deleteOrder(int orderId);

    Customer getOrderCustomer(int orderId);
}