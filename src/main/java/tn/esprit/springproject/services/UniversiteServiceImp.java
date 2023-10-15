package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.UniversiteRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversiteService{

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public Universite getUniversiteById(int id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(int id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public void assignUniversiteToDepartement(int idUniversite, int idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        universite.getDepartement().add(departement);
        universiteRepository.save(universite);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
            Universite universite = universiteRepository.findById(idUniversite).orElse(null);
            List<Departement> listDepart = new ArrayList<>();
        for (Departement d:universite.getDepartement()) {
            listDepart.add(d);
        }

        return listDepart;
    }


}
