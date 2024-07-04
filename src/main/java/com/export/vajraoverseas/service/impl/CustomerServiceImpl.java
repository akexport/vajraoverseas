package com.export.vajraoverseas.service.impl;

import com.export.vajraoverseas.dto.CustomerDto;
import com.export.vajraoverseas.entity.Customer;
import com.export.vajraoverseas.exception.ResourceNotFoundException;
import com.export.vajraoverseas.mapper.CustomerMapper;
import com.export.vajraoverseas.repository.CustomerRepository;
import com.export.vajraoverseas.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer does not exists with given Id : "+customerId));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    /**
     * @return
     */
    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }
}
