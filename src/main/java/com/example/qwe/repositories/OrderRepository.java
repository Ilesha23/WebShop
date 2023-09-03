package com.example.qwe.repositories;

import com.example.qwe.domain.Order;

import java.sql.*;
import java.util.Date;

public class OrderRepository {
    private static String INSERT_ORDER = "insert into orders (user, addr, date) values (?, ?, ?)";

    public Order create(Connection con, Order order) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(INSERT_ORDER, PreparedStatement.RETURN_GENERATED_KEYS)) {
            int i = 1, id;
            stmt.setString(i++, order.getLogin());
            stmt.setString(i++, order.getAddress());
            stmt.setTimestamp(i, new Timestamp(new Date().getTime()));
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (!rs.next()){
                    throw new RuntimeException("Can't find generated fields");
                }
                id = rs.getInt(1);
            }

            return new Order(id, order);
        }
    }
}
