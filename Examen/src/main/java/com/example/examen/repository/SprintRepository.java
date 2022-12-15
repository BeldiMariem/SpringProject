package com.example.examen.repository;

import com.example.examen.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
    @Query("SELECT  sprint FROM Sprint sprint where  sprint.startDate <=?1 ")
    List<Sprint> SprintDate(Date dateAuj);
}
