package com.essencia.resources;


import com.essencia.model.Customer;
import com.essencia.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerResouce {

    @Autowired
    private CostumerService costumerService;


    @CrossOrigin
    @GetMapping
    public @ResponseBody
    ResponseEntity<?> searchAllProposals(){
        try{
            Iterable<Customer> customers = this.costumerService.searchAllProposals();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Erro no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
