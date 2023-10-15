package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

    List<Equipe> findByEtudiantsIdEtudiant (Integer idEtudiant);
    List<Equipe> findByDetailEquipeThematiqueContains (String thematique);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Integer idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (Integer idEtudiant, Integer idDepart);

    @Query("Select e From Equipe e , DetailEquipe d where e.detailEquipe.idDetailEquipe=d.idDetailEquipe and e.niveau=?1 and d.thematique=?2")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);

    @Modifying
    @Transactional
    @Query("DELETE FROM Equipe e WHERE e.niveau=:niveau")
    void deleteEquipeByNiveau( Niveau niveau);
}
