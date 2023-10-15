package tn.esprit.springproject.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.repository.DetailEquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeServiceImp implements IDetailEquipeService{


    DetailEquipeRepository detailEquipeRepository;

    @Override
    public DetailEquipe getDetailEquipeById(int id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {
        return  detailEquipeRepository.save(d);
    }

    @Override
    public void deleteDetailEquipe(int id) {
        detailEquipeRepository.deleteById(id);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }
}
