package com.example.demo.repository.crud;

import com.example.demo.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepo extends CrudRepository<Admin, Integer> {
}
