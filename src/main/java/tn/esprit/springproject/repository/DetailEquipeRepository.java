package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Integer> {
    List<DetailEquipe> findByThematiqueLike (String thematique);
}
