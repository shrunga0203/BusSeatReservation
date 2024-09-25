package com.busseatreservation.repository;

import com.busseatreservation.entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopsRepository extends JpaRepository<Stops, Long> {
}