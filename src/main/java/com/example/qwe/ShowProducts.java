package com.example.qwe;

import com.example.qwe.domain.Item;
import com.example.qwe.services.ItemService;
import com.example.qwe.yakovlev.products.ItemsService;

//import java.beans.Statement;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class ShowProducts extends HttpServlet {

    private ItemService itemService;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        itemService = (ItemService) cfg.getServletContext().getAttribute("itemService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> list = itemService.getAllItems();
        //CartUtils.getCart(request.getSession());
        request.setAttribute("cont", list);
        request.getSession().setAttribute("cont", list);
        getServletContext().getRequestDispatcher("/shop.jsp").forward(request, response);
    }


    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List items = new LinkedList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "23012003");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from items");
            while (rs.next()) {
                List info = new LinkedList();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String descr = rs.getString(3);
                info.add(id);
                info.add(name);
                info.add(descr);
                items.add(info);

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            req.getSession().setAttribute("cont", items);
        } catch (Exception e) {
            throw new IOException(e);
        }

        getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
    }*/
}