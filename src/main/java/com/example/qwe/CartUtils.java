package com.example.qwe;

import com.example.qwe.domain.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartUtils {
    public static Cart getCart(HttpSession session){
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else {
            cart = (Cart)session.getAttribute("cart");
        }
        return cart;
    }

    public static int getCount(HttpSession session) {
//        int count;
//        if (session.getAttribute("count") == null) {
//            count = 0;
//        } else {
//            count = (int) session.getAttribute("count");
//        }
//        return count;
        return getCart(session).getSize();
    }

    public static void clearCart(HttpSession session){
        session.setAttribute("cart", new Cart());
    }

    public static void redirect(HttpServletRequest req, HttpServletResponse res, String path) throws IOException {
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + path));
    }

    public static void redirectBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("Referer") != null) {
            response.sendRedirect(request.getHeader("Referer"));
        } else {
            CartUtils.redirect(request, response, "/items");
        }
    }
}
