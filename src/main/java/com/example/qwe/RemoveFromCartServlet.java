package com.example.qwe;

import com.example.qwe.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = CartUtils.getCart(req.getSession());
        int index = -1;

        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            if (e.getKey() != null) {
                index = Integer.parseInt(e.getKey());
            }
        }

        if (index != -1) {
            cart.remove(index);
            int count = (int) req.getSession().getAttribute("countt");
            count--;
            req.getSession().setAttribute("countt", count);
            getServletContext().getRequestDispatcher("/cart.jsp").forward(req, resp);
        }
    }
}
