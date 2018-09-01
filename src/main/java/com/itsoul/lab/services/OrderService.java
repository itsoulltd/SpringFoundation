package com.itsoul.lab.services;

import com.itsoul.lab.repository.CustomerRepository;
import com.itsoul.lab.repository.InventoryItemRepository;
import com.itsoul.lab.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    private Integer id;

    private CustomerRepository customerRepository;

    @Autowired
    public OrderService(CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository, InventoryItemRepository inventoryItemRepository) {
        Random rand = new Random();
        id = rand.nextInt(1000) + 1;
        this.customerRepository = customerRepository;
    }

    @Override
    public String toString() {
        return (customerRepository != null)
                ? "This is OrderService (" + id + ") With " + customerRepository.toString()
                : "This is OrderService (" + id + ")";
    }
}
