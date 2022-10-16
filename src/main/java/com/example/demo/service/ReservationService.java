package com.example.demo.service;

import com.example.demo.model.DTOs.CompletedAndCancelled;
import com.example.demo.model.DTOs.TotalAndClient;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;

    public List<Reservation> getAll(){
        return reservationRepo.getAll();
    }

    public Optional<Reservation> getReservation(Integer idReservation){
        return reservationRepo.getReservation(idReservation);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepo.save(r);
        }else{
            Optional<Reservation> raux = reservationRepo.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepo.save(r);
            }else {
                return r;
            }
        }
    }

    //reto5
    public List<Reservation> getReservationPeriod(String d1, String d2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try{
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepo.getReservationPeriod(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        }
    }

    public CompletedAndCancelled getStatusReport(){
        List<Reservation> completed = reservationRepo.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepo.getReservationByStatus("Cancelled");

        int cantidadCompletadas = completed.size();
        int cantidadCanceladas = cancelled.size();

        return new CompletedAndCancelled((long) cantidadCompletadas, (long) cantidadCanceladas);
    }

    public List<TotalAndClient> getTopClientsReport(){
        return reservationRepo.getTopClients();
    }


}
