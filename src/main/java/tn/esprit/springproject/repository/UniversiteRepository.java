package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {

}
