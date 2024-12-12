package org.iit.eventsystem.resources;

public class TicketPoolResource {
    private long availableTickets;
    private long releasedTickets;
    private long totalTickets;
    private long maxTicketCapacity;

    public long getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(long availableTickets) {
        this.availableTickets = availableTickets;
    }

    public long getReleasedTickets() {
        return releasedTickets;
    }

    public void setReleasedTickets(long releasedTickets) {
        this.releasedTickets = releasedTickets;
    }

    public long getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(long totalTickets) {
        this.totalTickets = totalTickets;
    }

    public long getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(long maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}
