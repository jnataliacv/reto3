package com.example.demo.web;

import com.example.demo.model.Tool;
import com.example.demo.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Tool")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getTool(){
        return toolService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Tool> getTool(@PathVariable("id") Integer id){
        return toolService.getTool(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save(@RequestBody Tool t){
        return toolService.save(t);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update(@RequestBody Tool t){return toolService.update(t);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteTool(@PathVariable("id")Integer id){ return toolService.deleteTool(id);}

}
