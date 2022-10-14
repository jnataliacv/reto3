package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
