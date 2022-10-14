package com.example.demo.repository.crud;

import com.example.demo.model.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ToolCrudRepo extends CrudRepository<Tool, Integer> {
}
