package com.example.demo.web;

import com.example.demo.model.DTOs.CompletedAndCancelled;
import com.example.demo.model.DTOs.TotalAndClient;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2){
        return reservationService.getReservationPeriod(d1, d2);
    }

    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationStatus(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient> getCountClient(){return reservationService.getTopClientsReport();}
}