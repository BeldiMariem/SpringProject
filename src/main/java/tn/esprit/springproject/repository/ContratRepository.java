package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {

    Integer countByEtudiantIdEtudiantAndArchive(Integer idEtudiant,Boolean archive);
    List<Contrat> findByDateDebutContratAndDateFinContrat(Date d,Date f);
    @Query("SELECT  c FROM Contrat c where  c.dateDebutContrat >=? 1 and c.dateFinContrat <=? 2 ")
    List<Contrat> ListContratBetweenToDate(@PathVariable("dateD")Date dateD , @PathVariable("dateF")Date dateF);


}
