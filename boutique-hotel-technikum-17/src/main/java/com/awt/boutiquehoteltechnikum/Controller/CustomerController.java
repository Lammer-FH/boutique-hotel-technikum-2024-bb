package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.Interfaces.CustomerServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.CustomerMapper;
import com.awt.boutiquehoteltechnikum.Model.Customer;
import com.awt.boutiquehoteltechnikum.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceInterface customerService;

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.createCustomer(CustomerMapper.INSTANCE.customerDTOtoCustomer(customerDTO)));
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable int customerId) {
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.getCustomerById(customerId));
    }

    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.updateCustomer(CustomerMapper.INSTANCE.customerDTOtoCustomer(customerDTO)));
    }
}
