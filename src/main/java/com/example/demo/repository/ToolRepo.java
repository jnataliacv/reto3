package com.example.demo.repository;

import com.example.demo.model.Tool;
import com.example.demo.repository.crud.ToolCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepo {
    @Autowired
    private ToolCrudRepo toolCrudRepo;

    public List<Tool> getAll(){
        return (List<Tool>) toolCrudRepo.findAll();
    }

    public Optional<Tool> getTool(Integer idTool){
        return toolCrudRepo.findById(idTool);
    }

    public Tool save(Tool t){
        return toolCrudRepo.save(t);
    }

    public void delete(Tool t){
        toolCrudRepo.delete(t);
    }
}
