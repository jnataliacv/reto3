package com.example.demo.repository.crud;


import com.example.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepo extends CrudRepository<Client, Integer> {

}
