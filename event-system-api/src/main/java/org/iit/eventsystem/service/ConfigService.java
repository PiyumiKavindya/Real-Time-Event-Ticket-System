package org.iit.eventsystem.service;

import org.iit.eventsystem.domain.Config;
import org.iit.eventsystem.domain.TicketPool;
import org.iit.eventsystem.resources.ConfigResource;

public interface ConfigService {

    Config resetConfigValue(ConfigResource configResource);

    Config getCurrentConfig();

    void addTicketsToPool(long ticketsToAdd, long vendorId);

    void purchaseTicketsFromPool(long ticketsToPurchase, long customerId);

    TicketPool getTicketPool();
}
