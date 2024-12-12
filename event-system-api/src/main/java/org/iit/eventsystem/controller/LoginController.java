package org.iit.eventsystem.controller;

import org.iit.eventsystem.domain.Customer;
import org.iit.eventsystem.domain.Vendor;
import org.iit.eventsystem.resources.CustomerResource;
import org.iit.eventsystem.resources.VendorResource;
import org.iit.eventsystem.service.CustomerService;
import org.iit.eventsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("vendor/register")
    public ResponseEntity<Vendor> registerVendor(@RequestBody VendorResource vendorResource) {
        Vendor createdVendor = vendorService.createVendor(
                vendorResource.getUsername(),
                vendorResource.getEmail(),
                vendorResource.getPassword(),
                vendorResource.getMobileNo(),
                vendorResource.getIsAdmin()
        );
        return ResponseEntity.ok(createdVendor);
    }

    @PostMapping("vendor/login")
    public ResponseEntity<String> vendorLogin(@RequestBody VendorResource vendorResource) {
        String username = vendorResource.getUsername();
        String password = vendorResource.getPassword();

        if (username == null || password == null) {
            return ResponseEntity.badRequest().build(); // Handle missing fields
        }

        Vendor vendor = vendorService.vendorLogin(username, password);
        return ResponseEntity.ok("Vendor login successful.");
    }

    @PostMapping("customer/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerResource customerResource) {
        Customer createdCustomer = customerService.createCustomer(
                customerResource.getUsername(),
                customerResource.getEmail(),
                customerResource.getPassword(),
                customerResource.getMobileNo(),
                customerResource.getIs_premium()
        );
        return ResponseEntity.ok(createdCustomer);
    }

    @PostMapping("customer/login")
    public ResponseEntity<String> customerLogin(@RequestBody CustomerResource customerResource) {
        String username = customerResource.getUsername();
        String password = customerResource.getPassword();

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Username and password are required.");
        }

        customerService.customerLogin(username, password);
        return ResponseEntity.ok("Customer login successful.");
    }


}
