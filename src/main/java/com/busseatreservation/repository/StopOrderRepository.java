package com.busseatreservation.repository;

import com.busseatreservation.entity.StopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopOrderRepository extends JpaRepository<StopOrder, Long> {
}