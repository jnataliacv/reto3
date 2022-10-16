package com.example.demo.repository;


import com.example.demo.model.Client;
import com.example.demo.model.DTOs.TotalAndClient;
import com.example.demo.model.Reservation;
import com.example.demo.repository.crud.ReservationCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepo.findAllByStartDateAfterAndDevolutionDateBefore(dateOne, dateTwo);
    }
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepo.findAllByStatus(status);
    }
    public List<TotalAndClient> getTopClients(){
        List<TotalAndClient> res = new ArrayList<>();

        List<Object[]> report= reservationCrudRepo.getTotalReservationBYClient();
        for(int i = 0; i < report.size(); i++){
            /*
            Client cl=(Client) report.get(i)[0];
            Long cantidad = (Long) report.get(i)[1];
            CountClient cc = new CountClient(cantidad, cl);
            res.add(cc);
            */
            res.add(new TotalAndClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }
}
