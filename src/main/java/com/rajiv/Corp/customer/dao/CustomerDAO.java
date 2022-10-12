package com.rajiv.Corp.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajiv.Corp.customer.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
