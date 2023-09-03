package com.example.qwe;

import com.example.qwe.domain.Order;
import com.example.qwe.services.OrderService;
import com.example.qwe.domain.Cart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        orderService = (OrderService)config.getServletContext().getAttribute("orderService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("login") == null) {
            String error = "First you need to log in";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
            return;
        }

        Cart cart = CartUtils.getCart(request.getSession());
        if (cart.getSize() == 0) {
            CartUtils.redirect(request, response, "/order?error=Empty cart");
            return;
        }
//        check card
//        if (request.getParameter("addr") == null || request.getParameter("credit_card") == null) {
//            CartUtils.redirect(request, response, "/order?error=Invalid address or credit card");
//            return;
//        }
        System.out.println(request.getSession().getAttribute("login"));
        Order created = new Order(0, (String) request.getSession().getAttribute("login"),
                request.getParameter("addr"), cart.getItems());
        Order order = orderService.create(created);
        CartUtils.clearCart(request.getSession());
        request.setAttribute("order", order);
        request.setAttribute("cart", cart);
        request.setAttribute("price", cart.getPrice());
        getServletContext().getRequestDispatcher("/order-info.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = CartUtils.getCart(request.getSession());
        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}
