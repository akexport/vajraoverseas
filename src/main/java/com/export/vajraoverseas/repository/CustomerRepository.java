package com.export.vajraoverseas.repository;

import com.export.vajraoverseas.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
