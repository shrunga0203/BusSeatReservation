package com.busseatreservation.controller;

import com.busseatreservation.entity.Bus;
import com.busseatreservation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/buses")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @GetMapping
    public List<Bus> getBusesFromTo(
            @RequestParam String fromStopName,
            @RequestParam String toStopName) {
        return busRepository.findBusesFromTo(fromStopName,toStopName, LocalDate.of(2024,10,11));
    }
}
