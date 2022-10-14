package com.example.demo.repository.crud;

import com.example.demo.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepo extends CrudRepository<Reservation, Integer> {
}
