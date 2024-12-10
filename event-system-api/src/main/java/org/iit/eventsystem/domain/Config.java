package org.iit.eventsystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity //bean contolling
@Table(name ="config") //table name db and table connects here
@Data // getters and setters and data controlling
public class Config implements Serializable { //serializable is used to convert object into byte stream
    @Serial
    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "total_tickets", nullable = false)
    private Long totalTickets;

    @Column(name = "max_ticket_capacity", nullable = false)
    private Long maxTicketCapacity;

    @Column(name = "ticket_release_rate", nullable = false)
    private Long ticketReleaseRate;

    @Column(name = "customer_retrieval_rate", nullable = false)
    private Long customerRetrievalRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Long totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Long getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(Long maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public Long getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(Long ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public Long getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(Long customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }
}
