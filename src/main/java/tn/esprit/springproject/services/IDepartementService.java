package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;

import java.util.List;

public interface IDepartementService {

    public Departement getDepartementById(int id);

    public List<Departement> getAllDepartements();

    public Departement addDepartement(Departement d);

    public Departement updateDepartement(Departement d);

    public void deleteDepartement(int id);

}
