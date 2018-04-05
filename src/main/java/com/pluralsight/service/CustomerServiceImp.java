package com.pluralsight.service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)


// ANNOTATIONS
// add the stereotype bean type
//@Service("customerService")
public class CustomerServiceImp implements CustomerService {


// XML
    private CustomerRepository customerRepository;

//    public void setCustomerRepository(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

//    public CustomerServiceImp(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }



//ANNOTATIONS
//    @Autowired
//    private CustomerRepository customerRepository;
//


//    @Autowired
//    public void setCustomerRepository(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }


//    @Autowired
//    public CustomerServiceImp(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }





// JAVA injection
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }





    @Override
    public List<Customer> findAll() {
        return customerRepository.findAdd();
    }
}
