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

// this is where the biz logic lives
// This is needed for autowired - and removed the bean definition from the AppConfig
@Service("customerService")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImp implements CustomerService {
    // not an option, all is cohese like glue
//    @Autowired
    private CustomerRepository customerRepository;



//    setter autowire option 2
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // option 1 - member autowire
    //@Autowired
//    private CustomerRepository customerRepository;


    // option 3 - constructor autowire
//    @Autowired
//    public CustomerServiceImp(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAdd();
    }
}
