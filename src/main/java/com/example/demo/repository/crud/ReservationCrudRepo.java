package com.example.demo.repository.crud;

import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepo extends CrudRepository<Reservation, Integer> {

    //Reporte 1
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    // Reporte2
    public List<Reservation> findAllByStatus(String status);

    //Reporte3
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> getTotalReservationBYClient();
}
