package com.example.qwe.repositories;

import com.example.qwe.domain.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ItemRepository {
    private static String FIND_ALL = "select id, name, descr, price from items";
    private static String FIND_BY_ID = "select id, name, descr, price from items where id = ?";

    public List<Item> findAll(Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(FIND_ALL)) {
            List<Item> list = new LinkedList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(unmap(rs));
            }
            return list;
        }
    }

    public Item findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return unmap(rs);
            }
        }
        return null;
    }

    private Item unmap(ResultSet rs) throws SQLException {
        int i = 1;
        int id = rs.getInt(i++);
        String name = rs.getString(i++);
        String desc = rs.getString(i++);
        double price = rs.getDouble(i);
        System.out.println(id);
        System.out.println(name);
        System.out.println(desc);
        System.out.println(price);
        return new Item(id, name, desc, price);
    }
}
