package com.essencia.resources;

import com.essencia.dto.CustomerDto;
import com.essencia.repository.CustomerRepository;
import com.essencia.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fakedata")
public class FakeDataResource {

    @Autowired
    private CostumerService customerService;

    @CrossOrigin
    @GetMapping
    public String createFakeData(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setAge(25);
        customerDto.setCivilStatus("SINGLE");
        customerDto.setDependents(4);
        customerDto.setGener("M");
        customerDto.setSalary("20000");
        customerDto.setSocialId("08700209945");
        customerDto.setState("Santa Catarina");
        customerDto.setFullName("Guilherme César Medeiros");

        this.customerService.createCustomer(customerDto);

        customerDto = new CustomerDto();
        customerDto.setAge(25);
        customerDto.setCivilStatus("DIVORCED");
        customerDto.setDependents(4);
        customerDto.setGener("M");
        customerDto.setSalary("2000");
        customerDto.setSocialId("087001");
        customerDto.setState("Santa Catarina");
        customerDto.setFullName("Bruno");

        this.customerService.createCustomer(customerDto);

        return "Agora você tem dados!";
    }
}
