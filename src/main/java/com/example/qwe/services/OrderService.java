package com.example.qwe.services;

import com.example.qwe.domain.Order;
import com.example.qwe.repositories.OrderItemRepository;
import com.example.qwe.repositories.OrderRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderService {
    private TransactionManager transactionManager;
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public OrderService(TransactionManager transactionManager,
                        OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository) {
        super();
        this.transactionManager = transactionManager;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Order create(final Order src) {
        return transactionManager.doInTransaction(new TransactionOperation<Order>() {
            @Override
            public Order operation(Connection con) throws SQLException {
                Order returned = orderRepository.create(con, src);
                orderItemRepository.create(con, returned.getOrderNumber(), src.getItems());
                return returned;
            }
        });
    }
}
