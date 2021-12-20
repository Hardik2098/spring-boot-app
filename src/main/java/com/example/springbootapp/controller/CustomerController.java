package com.example.springbootapp.controller;

import com.example.springbootapp.entity.Customer;
import com.example.springbootapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(path = "/customer/new")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            service.addCustomer(customer);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer customerId) {
        try {
            Customer customer = service.getCustomer(customerId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/customer/get")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = service.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/customer/update/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
        try{
            service.updateCustomer(customerId, customer);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Customer", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/customer/delete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) {
        try{
            service.deleteCustomer(customerId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Customer", HttpStatus.BAD_REQUEST);
        }
    }
}
