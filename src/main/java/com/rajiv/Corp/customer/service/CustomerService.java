package com.rajiv.Corp.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rajiv.Corp.customer.dao.CustomerDAO;
import com.rajiv.Corp.customer.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	RestTemplate restTemplate;
	
	public void registerCustomer(Customer customer) {
		
		Customer customer2 = new Customer();
		customer2.setFirstName(customer.getFirstName());
		customer2.setEmail(customer2.getEmail());
		customer2.setId(customer.getId());
		customer2.setLastName(customer.getLastName());
		
		
		Boolean fraud = restTemplate.getForObject("http://localhost:8082/api/v1/fraud-check/1",
				Boolean.class,
				customer.getId());
		
		if(fraud) {
			throw new IllegalStateException("Customer is fraudster");
		}
		
		customerDAO.save(customer2);
		
	}

}
