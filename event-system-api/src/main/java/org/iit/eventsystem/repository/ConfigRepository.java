package org.iit.eventsystem.repository;

import org.iit.eventsystem.domain.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
    @Query("SELECT c FROM Config c WHERE c.id = :id")
    Optional<Config> getConfigById(@Param("id") Long id);

    boolean existsByTotalTicketsAndMaxTicketCapacityAndTicketReleaseRateAndCustomerRetrievalRate(
            Long totalTickets, Long maxTicketCapacity, Long ticketReleaseRate, Long customerRetrievalRate);
}
