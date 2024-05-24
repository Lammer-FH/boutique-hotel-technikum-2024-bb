package Controller;

import DTO.CustomerDTO;
import Model.Customer;
import Service.CustomerService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(modelMapper.map(customerDTO, Customer.class));
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) throws NotFoundException {
        return customerService.getCustomerById(customerId);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody CustomerDTO customerDTO) throws NotFoundException {
        return customerService.updateCustomer(modelMapper.map(customerDTO, Customer.class));
    }
}
