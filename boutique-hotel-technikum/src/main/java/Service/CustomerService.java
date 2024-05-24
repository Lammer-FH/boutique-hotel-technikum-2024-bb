package Service;

import Model.Booking;
import Model.Customer;
import Repository.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) throws NotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        if(customerOptional.isPresent()){
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            return customerRepository.save(existingCustomer);
        } else {
            throw new NotFoundException("Customer not found with id: " + customer.getId());
        }
    }

    public Customer getCustomerById(int id) throws NotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
    }
}
