package com.example.demo.service;

import com.example.demo.model.Tool;
import com.example.demo.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepo toolRepo;

    public List<Tool> getAll(){
        return toolRepo.getAll();
    }

    public Optional<Tool> getTool(Integer idTool){
        return toolRepo.getTool(idTool);
    }

    public Tool save(Tool t){
        if(t.getId()==null){
            return toolRepo.save(t);
        }else{
            Optional<Tool> taux = toolRepo.getTool(t.getId());
            if(taux.isEmpty()){
                return toolRepo.save(t);
            }else {
                return t;
            }
        }
    }

    public Tool update(Tool t){
        if (t.getId()!=null){
            Optional<Tool> taux = toolRepo.getTool(t.getId());
            if (taux.isPresent()){
                if (t.getName()!=null){
                    taux.get().setName(t.getName());
                }
                if (t.getBrand()!=null){
                    taux.get().setBrand(t.getBrand());
                }
                if (t.getYear()!=null){
                    taux.get().setYear(t.getYear());
                }
                if (t.getDescription()!=null){
                    taux.get().setDescription(t.getDescription());
                }
                toolRepo.save(taux.get());
                return taux.get();
            }else{
                return t;
            }
        }else {
            return t;
        }
    }

    public boolean deleteTool(Integer id){
        Optional<Tool> t = getTool(id);
        if (!t.isEmpty()){
            toolRepo.delete(t.get());
            return true;
        }
        return false;
    }
}
