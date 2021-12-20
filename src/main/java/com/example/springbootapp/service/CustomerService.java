package com.example.springbootapp.service;

import com.example.springbootapp.entity.Customer;
import com.example.springbootapp.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository repository;

    public void addCustomer(Customer customer) throws Exception {
        try {
            customer.getAccountDetails().forEach(accountDetail -> accountDetail.setCustomer(customer));
            repository.save(customer);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
    }

    public Customer getCustomer(Integer customerId) throws Exception {
        try {
            return repository.findById(customerId).get();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
    }

    public void updateCustomer(Integer customerId, Customer customer) throws Exception {
        try {
            customer.setCustomerId(customerId);
            customer.getAccountDetails().forEach(accountDetail -> accountDetail.setCustomer(customer));
            repository.save(customer);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
    }

    public void deleteCustomer(Integer customerId) throws Exception {
        try {
            repository.deleteById(customerId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
    }

    public List<Customer> getAllCustomers() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
    }
}
