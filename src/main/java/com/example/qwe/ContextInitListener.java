package com.example.qwe;

import com.example.qwe.repositories.ItemRepository;
import com.example.qwe.repositories.OrderItemRepository;
import com.example.qwe.repositories.OrderRepository;
import com.example.qwe.repositories.UserRepository;
import com.example.qwe.services.ItemService;
import com.example.qwe.services.OrderService;
import com.example.qwe.services.TransactionManager;
import com.example.qwe.services.UserService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        DataSource dataSource = null;
        try {
            Context initCtx = new InitialContext();
            dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/test"); //
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        TransactionManager transactionManager = new TransactionManager(dataSource);

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(transactionManager, userRepository);
        arg0.getServletContext().setAttribute("userService", userService);

        ItemRepository itemRepository = new ItemRepository();
        ItemService itemService = new ItemService(transactionManager, itemRepository);
        arg0.getServletContext().setAttribute("itemService", itemService);

        OrderRepository orderRepository = new OrderRepository();
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        OrderService orderService = new OrderService(transactionManager, orderRepository, orderItemRepository);;
        arg0.getServletContext().setAttribute("orderService", orderService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
