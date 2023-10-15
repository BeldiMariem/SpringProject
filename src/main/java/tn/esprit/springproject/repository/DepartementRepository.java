package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {

    @Query("SELECT d FROM Departement d , Etudiant e where d.idDepart=e.departement.idDepart and e.option=:op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);
}
