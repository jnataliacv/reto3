package com.example.demo.repository;

import com.example.demo.model.Message;
import com.example.demo.repository.crud.MessageCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepo {
    @Autowired
    private MessageCrudRepo messageCrudRepo;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepo.findAll();
    }

    public Optional<Message> getMessage(Integer idMessage){
        return messageCrudRepo.findById(idMessage);
    }
    public Message save(Message m){
        return messageCrudRepo.save(m);
    }
    public void delete(Message m){
        messageCrudRepo.delete(m);
    }
}
