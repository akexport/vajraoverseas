package com.export.vajraoverseas.mapper;

import com.export.vajraoverseas.dto.CustomerDto;
import com.export.vajraoverseas.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getMiddleName(),
                customer.getLastName(),
                customer.getContact(),
                customer.getEmail());
    }
    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getMiddleName(),
                customerDto.getLastName(),
                customerDto.getContact(),
                customerDto.getEmail());
    }
}
