package com.reactive.demo.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.demo.dao.CustomerDao;
import com.reactive.demo.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getCustomers(){
		
		return customerDao.getCustomers();
		
	}
	
    public Flux<Customer> getCustomerStream(){
		
		return customerDao.getCustomerStream();
		
	}
}
