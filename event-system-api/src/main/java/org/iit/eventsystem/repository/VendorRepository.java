package org.iit.eventsystem.repository;

import org.iit.eventsystem.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {

    Optional<Vendor> findVendorByUsernameAndPassword(String username, String password);

    Optional<Vendor> findVendorByEmail(String email);

    Optional<Vendor> findVendorById(long id);

}
