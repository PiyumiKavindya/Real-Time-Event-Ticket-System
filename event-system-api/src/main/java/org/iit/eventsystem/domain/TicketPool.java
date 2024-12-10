package org.iit.eventsystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name ="ticket_pool")
@Data
public class TicketPool implements Serializable {

    @Serial
    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "available_tickets", nullable = false)
    private long availableTickets;

    @Column(name = "released_tickets", nullable = false)
    private long releasedTickets;

    public synchronized boolean canAddTickets(long ticketsToAdd, long maxCapacity, long totalTickets) {
        if (releasedTickets + ticketsToAdd > totalTickets) {
            return false; // Exceeds total tickets
        }
        if (availableTickets + ticketsToAdd > maxCapacity) {
            return false; // Exceeds pool capacity
        }
        return true;
    }

    public synchronized void addTickets(long ticketsToAdd, long maxCapacity, long totalTickets) {
        if (!canAddTickets(ticketsToAdd, maxCapacity, totalTickets)) {
            throw new IllegalStateException("Cannot add tickets. Pool capacity or total tickets exceeded.");
        }
        availableTickets += ticketsToAdd;
        releasedTickets += ticketsToAdd;
    }

    public synchronized void purchaseTickets(long ticketsToPurchase) {
        if (ticketsToPurchase > availableTickets) {
            throw new IllegalStateException("Not enough tickets available for purchase.");
        }
        availableTickets -= ticketsToPurchase;
    }

    public long getAvailableTickets() {
        return availableTickets;
    }

    public long getReleasedTickets() {
        return releasedTickets;
    }

    public void setAvailableTickets(long availableTickets) {
        this.availableTickets = availableTickets;
    }

    public void setReleasedTickets(long releasedTickets) {
        this.releasedTickets = releasedTickets;
    }
}
