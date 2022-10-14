package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Message> getAll(){
        return messageRepo.getAll();
    }

    public Optional<Message> getMessage(Integer idMessage){
        return messageRepo.getMessage(idMessage);
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepo.save(m);
        }else{
            Optional<Message> maux = messageRepo.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return messageRepo.save(m);
            }else {
                return m;
            }
        }
    }

    public Message update(Message m){
        if (m.getIdMessage()!=null){
            Optional<Message> maux = messageRepo.getMessage(m.getIdMessage());
            if (maux.isPresent()){
                if (m.getMessageText()!=null){
                    maux.get().setMessageText(m.getMessageText());
                }
                messageRepo.save(maux.get());
                return maux.get();
            }else{
                return m;
            }
        }else {
            return m;
        }
    }


}
