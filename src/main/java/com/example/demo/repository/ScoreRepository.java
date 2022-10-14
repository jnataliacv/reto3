package com.example.demo.repository;

import com.example.demo.model.Score;
import com.example.demo.repository.crud.ScoreCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepo scoreCrudRepo;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepo.findAll();
    }

    public Optional<Score> getScore(Integer idScore){
        return scoreCrudRepo.findById(idScore);
    }

    public Score save(Score s){
        return scoreCrudRepo.save(s);
    }

    public void delete(Score s){
        scoreCrudRepo.delete(s);
    }
}
