package com.store.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.store.service.dao.Customer;
import com.store.service.dao.CustomerRepository;
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customer,RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Customer.class);
			customer.save(new Customer(null,"bouchaib","naimy",204));
			customer.save(new Customer(null,"bouchaib","naimy22",206));
			customer.save(new Customer(null,"bouchaib","naimy33",208));
			customer.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}

}
