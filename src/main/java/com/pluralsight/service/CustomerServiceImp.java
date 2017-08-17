package com.pluralsight.service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;

import java.util.List;

// this is where the biz logic lives
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;


    public CustomerServiceImp() {

    }

    public CustomerServiceImp(HibernateCustomerRepositoryImpl hibernateCustomerRepository) {
        this.customerRepository = hibernateCustomerRepository;
    }

    public void setrepositoryImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAdd();
    }
}
