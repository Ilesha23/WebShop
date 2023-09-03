package com.example.qwe;

import com.example.qwe.domain.Cart;
import com.example.qwe.domain.Item;
import com.example.qwe.yakovlev.products.ItemsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");


        int index = Integer.parseInt(req.getParameter("id")) - 1;

        HttpSession session = req.getSession();
        Cart cart = CartUtils.getCart(session);
        List cont = (List) session.getAttribute("cont");
        //int count = CartUtils.getCount(session);


        if (cart == null) {
            cart = new Cart();
            //count = 0;
        }

        cart.add((Item) cont.get(index));
        //count++;

        session.setAttribute("cart", cart);
        session.setAttribute("countt", cart.getSize());
        req.setAttribute("cont", cont);
        getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
    }
}
