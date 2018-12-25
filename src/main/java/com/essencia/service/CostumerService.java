package com.essencia.service;


import com.essencia.dto.CustomerDto;
import com.essencia.model.CivilStatus;
import com.essencia.model.Customer;
import com.essencia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CostumerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
    private FileStorageService fileStorageService;

	/**
	 * Busca todas as {@link Customer}
	 * @return {@link Iterable}
	 */
	public Iterable<Customer> searchAllCustumers(){
		return this.customerRepository.findAll();
	}


	/**
	 * Cria uma nova {@link Customer}
	 * @param customerDto {@link CustomerDto}
	 * @return {@link Customer}
	 */
   	public Customer createCustomer(CustomerDto customerDto){
		Customer customer = new Customer(customerDto.getFullName(), customerDto.getSocialId());
		customer.setAge(customerDto.getAge());
		customer.setCivilStatus(CivilStatus.valueOf(customerDto.getCivilStatus().toUpperCase()));
		customer.setDependents(customerDto.getDependents());
		customer.setState(customerDto.getState());
		customer.setSalary(new BigDecimal(customerDto.getSalary()));
		customer.setGener(customerDto.getGener().charAt(0));

		this.customerRepository.save(customer);
		this.fileStorageService.storeFile(customerDto.getImage());


		return customer;
	}

}
