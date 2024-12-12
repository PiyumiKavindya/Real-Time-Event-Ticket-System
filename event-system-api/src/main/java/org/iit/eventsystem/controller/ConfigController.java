package org.iit.eventsystem.controller;

import org.iit.eventsystem.domain.Config;
import org.iit.eventsystem.resources.ConfigResource;
import org.iit.eventsystem.service.ConfigService;
import org.iit.eventsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @Autowired
    private VendorService vendorService;

    @PostMapping("/init-config")
    public ResponseEntity<String> setConfigurations(@RequestBody ConfigResource configResource) {
        try {
            // Validate ConfigDto values
            validateConfigDto(configResource);

            // Extract fields and pass to VendorService
            int totalTickets = configResource.getTotalTickets();
            int maxCapacity = configResource.getTicketMaxCapacity();
            int ticketReleaseRate = configResource.getTicketReleaseRate();
            int customerRetrievalRate = configResource.getCustomerRetrievalRate();

            vendorService.setConfigurations(totalTickets, maxCapacity, ticketReleaseRate, customerRetrievalRate);
            return ResponseEntity.ok("Parameters set successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

//    {
//        "totalTickets": 500,
//        "maxCapacity": 100,
//        "ticketReleaseRate": 10,
//        "customerRetrievalRate": 5
//    }

    @GetMapping("/get-config")
    public ResponseEntity<Config> getConfig() {
        Config config = configService.getCurrentConfig();
        if (config == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(config);
    }

    @PostMapping("/set-config")
    public ResponseEntity<Config> resetConfig(@RequestBody ConfigResource configResource) {
        // Validate ConfigDto values manually
        validateConfigDto(configResource);

        // Proceed with the rest of the logic
        Config config = configService.resetConfigValue(configResource);
        return ResponseEntity.ok(config);
    }

    private void validateConfigDto(ConfigResource configResource) {
        // Validate individual fields
        if (configResource.getTotalTickets() <= 0) {
            throw new IllegalArgumentException("Total tickets must be greater than 0.");
        }
        if (configResource.getTicketMaxCapacity() <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than 0.");
        }
        if (configResource.getTicketReleaseRate() <= 0) {
            throw new IllegalArgumentException("Ticket release rate must be greater than 0.");
        }
        if (configResource.getCustomerRetrievalRate() <= 0) {
            throw new IllegalArgumentException("Customer retrieval rate must be greater than 0.");
        }

        // Additional validation: maxCapacity cannot exceed totalTickets
        if (configResource.getTicketMaxCapacity() > configResource.getTotalTickets()) {
            throw new IllegalArgumentException("Max capacity cannot exceed total tickets.");
        }

        // Additional validation: ticketReleaseRate cannot exceed maxCapacity
        if (configResource.getTicketReleaseRate() > configResource.getTicketMaxCapacity()) {
            throw new IllegalArgumentException("Ticket release rate cannot exceed max capacity.");
        }

        // Additional validation: ticketReleaseRate cannot exceed totalTickets
        if (configResource.getTicketReleaseRate() > configResource.getTotalTickets()) {
            throw new IllegalArgumentException("Ticket release rate cannot exceed total tickets.");
        }
    }

}
