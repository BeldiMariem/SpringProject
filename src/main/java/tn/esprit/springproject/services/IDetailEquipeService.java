package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {

    public DetailEquipe getDetailEquipeById(int id);

    public List<DetailEquipe> getAllDetailEquipe();

    public DetailEquipe addDetailEquipe(DetailEquipe d);

    public DetailEquipe updateDetailEquipe(DetailEquipe d);

    public void deleteDetailEquipe(int id);
    List<DetailEquipe> findByThematiqueLike (String thematique);
}
