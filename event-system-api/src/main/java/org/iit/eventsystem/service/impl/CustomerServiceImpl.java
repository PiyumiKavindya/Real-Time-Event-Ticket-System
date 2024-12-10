package org.iit.eventsystem.service.impl;

import org.iit.eventsystem.domain.Customer;
import org.iit.eventsystem.exception.UserAlreadyExistsException;
import org.iit.eventsystem.exception.UserNotFoundException;
import org.iit.eventsystem.repository.CustomerRepository;
import org.iit.eventsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(String username, String email, String password, Long mobileNo, Boolean is_premium) {
        // Check if a customer with the same email exists
        if (customerRepository.findCustomerByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("Customer with email " + email + " already exists.");
        }
        // Check if isPremium is null and set default value
        if (is_premium == null) {
            is_premium = false; // Default value if null
        }

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobileNo(mobileNo);
        customer.setIs_premium(is_premium);
        return customerRepository.save(customer);
    }

    @Override
    public void customerLogin(String username, String password) {
        customerRepository.findCustomerByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("Invalid username or password!"));
    }
}
