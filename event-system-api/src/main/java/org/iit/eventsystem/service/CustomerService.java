package org.iit.eventsystem.service;

import org.iit.eventsystem.domain.Customer;

public interface CustomerService {
    Customer createCustomer(String username, String email, String password, Long mobileNo, Boolean is_premium);

    void customerLogin(String username, String password);
}
