package com.ak4.service;

import com.ak4.entity.CustomerEntity;
import com.ak4.mapper.CustomerMapper;
import com.ak4.repository.CustomerRepository;
import com.ak4.schema.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerMapper.from(customer);
        CustomerEntity createdCustomerEntity = customerRepository.save(customerEntity);
        return customerMapper.from(createdCustomerEntity);
    }

    public Customer fetchCustomer(String customerId) {
        CustomerEntity fetchedCustomerEntity = customerRepository.getOne(customerId);
        return customerMapper.from(fetchedCustomerEntity);
    }

    public String getCustomerByUsername(String username) {
        return customerRepository.getCustomerByUserName(username);
    }
}
