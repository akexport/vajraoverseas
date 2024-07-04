package com.export.vajraoverseas.service;

import com.export.vajraoverseas.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long customerId);
    List<CustomerDto> getAllCustomers();
}
