package org.iit.eventsystem.service;

import jakarta.servlet.http.HttpSession;
import org.iit.eventsystem.domain.Vendor;

public interface VendorService {

    Vendor createVendor(String username, String email, String password, Long mobileNo, Boolean isAdmin);

    Vendor vendorLogin(String username, String password);

    void setConfigurations(int totalTickets, int maxCapacity, int ticketReleaseRate, int customerRetrievalRate);
}
