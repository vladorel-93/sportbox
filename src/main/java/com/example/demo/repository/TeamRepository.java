package com.example.demo.repository;

import com.example.demo.entities.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 1 on 04.06.2018.
 */
@Repository("teamRepository")
public interface TeamRepository extends CrudRepository<Team, Integer>{
}
