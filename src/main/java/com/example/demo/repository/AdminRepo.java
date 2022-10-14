package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.repository.crud.AdminCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepo{
    @Autowired
    private AdminCrudRepo adminCrudRepo;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepo.findAll();
    }

    public Optional<Admin> getAdmin(Integer idAdmin){
        return adminCrudRepo.findById(idAdmin);
    }

    public Admin save(Admin a){
        return adminCrudRepo.save(a);
    }

    public void delete(Admin a){
        adminCrudRepo.delete(a);
    }
}
