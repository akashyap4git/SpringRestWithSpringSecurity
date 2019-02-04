package com.ak4.mapper;

import com.ak4.entity.AddressEntity;
import com.ak4.entity.CustomerEntity;
import com.ak4.schema.Address;
import com.ak4.schema.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity from(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setPassword(customer.getPassword());
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine(customer.getAddress().getAddressLine());
        addressEntity.setCity(customer.getAddress().getCity());
        addressEntity.setZipCode(customer.getAddress().getZipCode());
        customerEntity.setAddressEntity(addressEntity);
        return customerEntity;
    }

    public Customer from(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getCustomerId());
        customer.setName(customerEntity.getName());
        customer.setUsername(customerEntity.getUsername());
        customer.setPassword(customerEntity.getPassword());
        Address address = new Address();
        address.setAddressId(customerEntity.getAddressEntity().getAddressId());
        address.setAddressLine(customerEntity.getAddressEntity().getAddressLine());
        address.setCity(customerEntity.getAddressEntity().getCity());
        address.setZipCode(customerEntity.getAddressEntity().getZipCode());
        customer.setAddress(address);
        return customer;
    }
}
