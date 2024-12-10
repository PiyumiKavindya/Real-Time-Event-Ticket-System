package org.iit.eventsystem.repository;

import org.iit.eventsystem.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findCustomerByUsernameAndPassword(String username, String password);

    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findCustomerById(long customerId);

}
