package actors;

import logger.Logger;
import ticketPool.TicketPool;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;

    public Customer(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(customerRetrievalRate * 1000L); // Retrieve tickets at a specified rate
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interrupted status
                //System.out.println("Customer thread interrupted.");
                Logger.log("Customer thread interrupted.");
                return;
            }

            synchronized (ticketPool) {
                if (ticketPool.getCurrentSize() > 0) {
                    Integer ticketId = ticketPool.removeTicket();
                    //System.out.println("Customer bought Ticket ID: " + ticketId + " | Tickets Remaining: " + ticketPool.getCurrentSize());
                    Logger.log("Customer bought Ticket ID: " + ticketId + " | Tickets Remaining: " + ticketPool.getCurrentSize());
                } else if (Vendor.ticketsAddedSoFar == ticketPool.getTotalTickets()) {
                    //System.out.println("All tickets have been bought. Stopping customers...");
                    Logger.log("All tickets have been bought. Stopping customers...");
                    return;
                }
            }
        }
    }
}
