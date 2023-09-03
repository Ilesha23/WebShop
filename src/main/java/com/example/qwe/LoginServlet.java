package com.example.qwe;

import com.example.qwe.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService)config.getServletContext().getAttribute("userService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");

        if (userService.login(login, pwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            if (request.getHeader("Referer") != null && request.getHeader("Referer").contains("/login")) {
                CartUtils.redirect(request, response, "/shop");
            } else {
                CartUtils.redirectBack(request, response);
            }
        } else {
            request.setAttribute("status", "Incorrect login or password");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
