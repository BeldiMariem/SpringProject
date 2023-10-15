package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;

import javax.transaction.Transactional;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
public List<Etudiant> findByPrenomEContains(String prenom);

   @Query("Select e.etudiants from Equipe e , DetailEquipe d where e.detailEquipe.idDetailEquipe=d.idDetailEquipe and d.thematique=?1")
    List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);


    @Modifying
    @Transactional
    @Query("update Etudiant e set e.option=:op where e.idEtudiant=:idEtudiant")
    void updateEtudiantByOption(@Param("op") Option op ,@Param("idEtudiant") int idEtudiant);


    Etudiant findByNomEAndPrenomE(String nom ,String prenom);

    List<Etudiant> findByDepartementIdDepart(Integer departementId);

}
