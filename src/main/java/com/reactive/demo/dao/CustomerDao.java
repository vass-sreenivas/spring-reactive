package com.reactive.demo.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.reactive.demo.dto.Customer;

import reactor.core.publisher.Flux;

@Repository
public class CustomerDao {

	
	public List<Customer> getCustomers(){
		
		return IntStream.rangeClosed(1, 50)
				        .peek(i->{
				        	try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        	System.out.println("Processing Count:"+i);	
				        })
				        .mapToObj(i->new Customer(i, "Customer"+i))
				        .collect(Collectors.toList());
	}
	
	
   public Flux<Customer> getCustomerStream(){
		
	   return Flux.range(1, 50)
	       .delayElements(Duration.ofMillis(1000))
	       .doOnNext(i->System.out.println("Processiong Count Stream"+i))
	       .map(i->new Customer(i,"Customer"+i));
	       
	       
	}
}
