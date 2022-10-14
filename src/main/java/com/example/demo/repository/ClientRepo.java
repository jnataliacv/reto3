package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.repository.crud.ClientCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepo {
    @Autowired
    private ClientCrudRepo clientCrudRepo;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepo.findAll();
    }

    public Optional<Client> getClient(Integer idClient){
        return clientCrudRepo.findById(idClient);
    }

    public Client save(Client cl){
        return clientCrudRepo.save(cl);
    }

    public void delete(Client c){
        clientCrudRepo.delete(c);
    }

}
