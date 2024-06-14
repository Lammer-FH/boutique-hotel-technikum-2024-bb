package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.CustomerRequestDTO;
import com.awt.boutiquehoteltechnikum.Interfaces.CustomerServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.CustomerMapper;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceInterface customerService;

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerRequestDTO customerDTO) {
        CustomerEntity customerEntity = CustomerMapper.INSTANCE.customerRequestDTOtoCustomer(customerDTO);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.createCustomer(customerEntity));
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
