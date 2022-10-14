package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getAll(){
        return clientRepo.getAll();
    }

    public Optional<Client> getClient(Integer idClient){
        return clientRepo.getClient(idClient);
    }

    public Client save(Client cl){
        if(cl.getIdClient()==null){
            return clientRepo.save(cl);
        }else{
            Optional<Client> claux = clientRepo.getClient(cl.getIdClient());
            if(claux.isEmpty()){
                return clientRepo.save(cl);
            }else {
                return cl;
            }
        }
    }

    public Client update(Client cl){
        if(cl.getIdClient()!=null){
            Optional<Client> claux = clientRepo.getClient(cl.getIdClient());
            if(claux.isPresent()){
                if (cl.getEmail()!=null){
                    claux.get().setEmail(cl.getEmail());
                }
                if (cl.getPassword()!=null){
                    claux.get().setPassword(cl.getPassword());
                }
                if (cl.getName()!=null){
                    claux.get().setName(cl.getName());
                }
                if (cl.getAge()!=null){
                    claux.get().setAge(cl.getAge());
                }
                clientRepo.save(claux.get());
                return claux.get();
            }else {
                return cl;
            }
        }else{
            return cl;
        }
    }

    public boolean deleteClient(Integer idClient){
        Optional<Client> c = getClient(idClient);
        if (!c.isEmpty()){
            clientRepo.delete(c.get());
            return true;
        }
        return false;
    }

}
