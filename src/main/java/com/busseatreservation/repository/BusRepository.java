package com.busseatreservation.repository;

import com.busseatreservation.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    @Query("""
          SELECT DISTINCT b
          FROM Bus b
          JOIN StopOrder so1 ON b.id = so1.bus.id
          JOIN Stops s1 ON so1.stops.id = s1.id
          JOIN StopOrder so2 ON b.id = so2.bus.id
          JOIN Stops s2 ON so2.stops.id = s2.id
          WHERE s1.stopName = :fromStopName
          AND s2.stopName = :toStopName
          AND so1.departureDate = :departureDate
  """)
    List<Bus> findBusesFromTo(
            @Param("fromStopName") String fromStopName,
            @Param("toStopName") String toStopName,
            @Param("departureDate") LocalDate departureDate);
}