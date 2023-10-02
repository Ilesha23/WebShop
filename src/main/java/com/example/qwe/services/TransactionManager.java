package com.example.qwe.services;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    @Resource(name = "dbDataSource")
    private DataSource ds;

    public TransactionManager(DataSource ds) {
        this.ds = ds;
    }

    public <T> T doInTransaction(TransactionOperation<T> op) {
        Connection con = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            T result = op.operation(con);

            con.commit();
            return result;
        } catch(Exception ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch(SQLException ex2){
                ex2.printStackTrace();      //TODO Bad practice, use logging engine
            }
            throw new RuntimeException(ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch(SQLException ex2){
                    ex2.printStackTrace();      //TODO Bad practice, use logging engine
                }
            }
        }
    }
}
