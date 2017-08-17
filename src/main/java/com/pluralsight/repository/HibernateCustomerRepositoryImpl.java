package com.pluralsight.repository;

import com.pluralsight.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAdd() {
        List<Customer> customers = new ArrayList<Customer>();
        Customer c = new Customer();
        c.setFirstName("nome");
        c.setLastName("cognome");
        customers.add(c);
        return customers;
    }
}
