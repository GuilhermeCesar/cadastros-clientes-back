package com.essencia.resources;


import com.essencia.dto.CustomerDto;
import com.essencia.model.Customer;
import com.essencia.service.CostumerService;
import com.essencia.service.FileStorageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerResource {

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
    public @ResponseBody ResponseEntity<?> createCustomer(@RequestParam(name = "image", required = false) MultipartFile image,
                                                          @RequestParam(name = "fullName", required = false) String fullName,
                                                          @RequestParam(name = "socialId", required = false) String socialId,
                                                          @RequestParam(name = "gener", required = false) String gener,
                                                          @RequestParam(name = "civilStatus", required = false) String civilStatus,
                                                          @RequestParam(name = "age", required = false) Integer age,
                                                          @RequestParam(name = "dependents", required = false) Integer dependents,
                                                          @RequestParam(name = "state", required = false) String state,
                                                          @RequestParam(name = "telephone", required = false) String telephone,
                                                          @RequestParam(name = "email", required = false)String email){
        try {
            CustomerDto customerDto = new CustomerDto(fullName, socialId, age, gener);
            customerDto.setCivilStatus(civilStatus);
            customerDto.setDependents(dependents);
            customerDto.setState(state);
            customerDto.setImage(image);
            customerDto.setTelephone(telephone);
            customerDto.setEmail(email);

            Customer customer = this.costumerService.createCustomer(customerDto);

            return new ResponseEntity<>(customer,HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>("Erro no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String filename, HttpServletRequest request){
        Resource resource = this.fileStorageService.loadFileAsResouce(filename);

        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        if(StringUtils.isBlank(contentType)){
            contentType = MediaType.IMAGE_JPEG_VALUE;
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "filename\"".concat(resource.getFilename()).concat("\""))
                .body(resource);

    }
}
