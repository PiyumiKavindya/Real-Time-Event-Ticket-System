package org.iit.eventsystem.resources;

import lombok.Data;

@Data
public class TicketRequesResource {
    private String type;
    private long count;
    private long vendorId;
    private long customerId;
}
