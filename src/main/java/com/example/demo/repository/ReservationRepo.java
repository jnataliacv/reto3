package com.example.demo.repository;


import com.example.demo.model.Reservation;
import com.example.demo.repository.crud.ReservationCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepo {

    @Autowired
    private ReservationCrudRepo reservationCrudRepo;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepo.findAll();
    } // function to find all the items as a list , returns findAll function from the CrudRepo

    public Optional<Reservation> getReservation(Integer idReservation){
        return reservationCrudRepo.findById(idReservation);
    }  // Creates an Optional object to handle reservation id if it is null (easier to handle null values with optional object)

    public Reservation save(Reservation r){
        return reservationCrudRepo.save(r);
    } // saves the reservation object

    public void delete(Reservation r){
        reservationCrudRepo.delete(r);
    }
}
