package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.CustomerRequestDTO;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateCustomerCommand;
import com.awt.boutiquehoteltechnikum.Interfaces.CustomerServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.CustomerMapper;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/api/hotel/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceInterface customerService;

    @PostMapping
    public CustomerDTO createCustomer(@Valid @RequestBody CustomerRequestDTO customerDTO) {
        CreateCustomerCommand createCustomerCommand = CustomerMapper.INSTANCE.customerRequestDTOtoCreateCustomerCommand(customerDTO);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.createCustomer(createCustomerCommand));
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable int customerId) {
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.getCustomerById(customerId));
    }

    @PutMapping
    public CustomerDTO updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerService.updateCustomer(CustomerMapper.INSTANCE.customerDTOtoCustomer(customerDTO)));
    }
}
