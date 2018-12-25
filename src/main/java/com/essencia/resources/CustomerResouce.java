package com.essencia.resources;


import com.essencia.dto.CustomerDto;
import com.essencia.model.Customer;
import com.essencia.service.CostumerService;
import com.essencia.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerResouce {

    @Autowired
    private CostumerService costumerService;
    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public @ResponseBody
    ResponseEntity<?> searchAllCustomer(){
        try{
            Iterable<Customer> customers = this.costumerService.searchAllCustumers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Erro no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> createCustomer(@RequestParam(name = "image") MultipartFile image,
                                                          @RequestParam(name = "fullName") String fullName,
                                                          @RequestParam(name = "socialId") String socialId,
                                                          @RequestParam(name = "gener") String gener,
                                                          @RequestParam(name = "civilStatus") String civilStatus,
                                                          @RequestParam(name = "age") Integer age,
                                                          @RequestParam(name = "dependents") Integer dependents,
                                                          @RequestParam(name = "state") String state,
                                                          @RequestParam(name = "salary") String salary){
        try {

            CustomerDto customerDto = new CustomerDto(fullName, socialId, age, gener);
            customerDto.setCivilStatus(civilStatus);
            customerDto.setDependents(dependents);
            customerDto.setState(state);
            customerDto.setSalary(salary);
            customerDto.setImage(image);

            this.costumerService.createCustomer(customerDto);

            return new ResponseEntity<>("Salvo com sucesso",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Erro no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
