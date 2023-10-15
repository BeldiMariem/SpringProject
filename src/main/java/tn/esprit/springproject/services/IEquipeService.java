package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Equipe;

import java.util.List;

public interface IEquipeService  {

    public Equipe getEquipeById(int id);

    public List<Equipe> getAllEquipes();

    public Equipe addEquipe(Equipe e);

    public Equipe updateEquipe(Equipe e);

    public void deleteEquipe(int id);

    public List<Equipe> findByEtudiantsIdEtudiant (Integer idEtudiant);

    public List<Equipe> findByDetailEquipeThematiqueContains (String thematique);

    public     List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Integer idEtudiant);

    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (Integer idEtudiant, Integer idDepart);


}
