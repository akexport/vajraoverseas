package com.export.vajraoverseas.controller;

import com.export.vajraoverseas.dto.CustomerDto;
import com.export.vajraoverseas.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
         return ResponseEntity.ok(customerDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customerDtos = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDtos);
    }


}
