package com.example.examen.repository;

import com.example.examen.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
