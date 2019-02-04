package com.ak4.rest;

import com.ak4.exception.UserAlreadyExistException;
import com.ak4.schema.Customer;
import com.ak4.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("service/myapp/")
public class CustomerRestController {

    protected Logger log = LoggerFactory.getLogger(CustomerRestController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "fetchCustomer/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerDetails(@PathVariable("customerId") String customerId) {
        log.info("getCustomerDetails() is called -> -> -> ->");
        return customerService.fetchCustomer(customerId);
    }

    @RequestMapping(value = "createCustomer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        String username = customerService.getCustomerByUsername(customer.getUsername());
        if(username != null) {
            throw new UserAlreadyExistException("User is already exist");
        }
        log.info("createCustomer() is called -> -> -> ->");
        return customerService.createCustomer(customer);
    }

    @GetMapping("/principal")
        String greeting(Principal principal) {
            return "Hello " + principal.getName() + "!";
        }
}
