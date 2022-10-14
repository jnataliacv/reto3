package com.example.demo.repository.crud;

import com.example.demo.model.Category;
import org.springframework.data.repository.CrudRepository;
public interface CategoryCrudRepo extends CrudRepository <Category, Integer> { //componenete que gestiona los crud

}
