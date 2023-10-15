package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.repository.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImp implements IEquipeService{


    EquipeRepository equipeRepository;

    @Override
    public Equipe getEquipeById(int id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(int id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiant (Integer idEtudiant){
        return equipeRepository.findByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByDetailEquipeThematiqueContains (String thematique){
        return equipeRepository.findByDetailEquipeThematiqueContains(thematique);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Integer idEtudiant){
        return equipeRepository.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

   @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (Integer idEtudiant, Integer idDepart)
    {
        return equipeRepository.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

}
