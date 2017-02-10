package com.ehc.elasticsearchdemo.web;

import com.ehc.elasticsearchdemo.model.Customer;
import com.ehc.elasticsearchdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ehc on 9/2/17.
 */
@RestController
public class HomeController {
  @Autowired
  CustomerRepository customerRepository;

  @RequestMapping(value = "/customer")
  public Customer createCustomer() {
    Customer customer = new Customer(1, "mjsa", "fsdf","17.4286303,78.4154022");
    return customerRepository.save(customer);
  }
}
