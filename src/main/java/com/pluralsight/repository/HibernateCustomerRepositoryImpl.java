package com.pluralsight.repository;

import com.pluralsight.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// annotations method - stereotype
@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    @Value("${connString}")
    private String connString;

    @Override
    public List<Customer> findAdd() {
        System.out.println(this.connString);
        List<Customer> customers = new ArrayList<Customer>();
        Customer c = new Customer();
        c.setFirstName("nome");
        c.setLastName("cognome");
        customers.add(c);
        return customers;
    }
}
