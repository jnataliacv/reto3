package com.example.demo.repository.crud;

import com.example.demo.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepo extends CrudRepository<Score, Integer> {
}
