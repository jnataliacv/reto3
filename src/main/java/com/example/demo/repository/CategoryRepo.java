package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.repository.crud.CategoryCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository      //componente de spring que permite hacer transacciones con la base de datos CRUD
public class CategoryRepo  {

    @Autowired
    private CategoryCrudRepo categoryCrudRepo;

    public List<Category> getAll(){    //gets all the items from the database as a list
        return  (List<Category>) categoryCrudRepo.findAll();
    }
    //Optional is for working with null values
    public Optional<Category> getCategory(Integer idCategory){    // gets category object by id as an optional object
        return categoryCrudRepo.findById(idCategory);
    }

    public Category save(Category c){
        return categoryCrudRepo.save(c);
    }

    public void delete(Category c){
        categoryCrudRepo.delete(c);
    }
}
