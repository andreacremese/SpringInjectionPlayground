package com.pluralsight.repository;

import com.pluralsight.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository("customerRepository")
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
