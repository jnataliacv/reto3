package com.example.demo.repository.crud;

import com.example.demo.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepo extends CrudRepository<Message, Integer> {
}
