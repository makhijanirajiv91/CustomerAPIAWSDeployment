package com.rajiv.Corp.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rajiv.Corp.customer.model.Customer;
import com.rajiv.Corp.customer.service.CustomerService;


@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer customer) {
		
		customerService.registerCustomer(customer);
		
		return "Customer Registered Successfully...";
		
	}

}
