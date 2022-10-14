package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category>getAll(){
        return categoryRepo.getAll();
    }

    public Optional<Category> getCategory(Integer idCategory){
        return categoryRepo.getCategory(idCategory);
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepo.save(c);
        }else{
            Optional<Category> caux = categoryRepo.getCategory(c.getId());
            if(caux.isEmpty()){
                return categoryRepo.save(c);
            }else {
                return c;
            }
        }
    }

    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> caux = categoryRepo.getCategory(c.getId());  // saves the id of the category inside an optional caux variable if id exists
            if(caux.isPresent()){
                if(c.getName()!=null){
                    caux.get().setName(c.getName());
                }
                if (c.getDescription()!=null){
                    caux.get().setDescription(c.getDescription());
                }
                categoryRepo.save(caux.get());
                return caux.get();
            }else {
                return c;
            }
        }else {
            return c;
        }
    }

    public boolean deleteCategory(Integer idCategory){
        Optional<Category> ca = getCategory(idCategory);
        if (!ca.isEmpty()){
            categoryRepo.delete(ca.get());
            return true;
        }
        return false;
    }
}
