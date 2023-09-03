package com.example.qwe.services;

import com.example.qwe.domain.Item;
import com.example.qwe.repositories.ItemRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemService {
    private TransactionManager transactionManager;
    private ItemRepository itemRepository;

    public ItemService(TransactionManager transactionManager, ItemRepository itemRepository) {
        this.transactionManager = transactionManager;
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return transactionManager.doInTransaction(new TransactionOperation<List<Item>>() {
            @Override
            public List<Item> operation(Connection con) throws SQLException {
                return itemRepository.findAll(con);
            }
        });
    }

    public Item getById(final String id){
        return transactionManager.doInTransaction(new TransactionOperation<Item>() {
            @Override
            public Item operation(Connection con) throws SQLException {
                return itemRepository.findById(con, id);
            }
        });
    }
}
