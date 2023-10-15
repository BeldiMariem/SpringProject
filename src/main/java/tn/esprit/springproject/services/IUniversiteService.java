package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    public Universite getUniversiteById(int id);

    public List<Universite> getAllUniversites();

    public Universite addUniversite(Universite u);

    public Universite updateUniversite(Universite u);

    public void deleteUniversite(int id);

    public void assignUniversiteToDepartement(int idUniversite, int idDepartement);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

}
