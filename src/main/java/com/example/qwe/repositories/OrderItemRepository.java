package com.example.qwe.repositories;

import com.example.qwe.domain.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderItemRepository {
    private static String INSERT_ORDER = "insert into ordersItems (order_id, item_id, price) values (?, ?, ?)";

    public void create(Connection con, int orderId, List<Item> items) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(INSERT_ORDER)) {
            for (Item item : items) {
                int i = 1;
                stmt.setInt(i++, orderId);
                stmt.setInt(i++, item.getId());
                stmt.setDouble(i, item.getPrice());
                stmt.executeUpdate();
            }
        }
    }
}
