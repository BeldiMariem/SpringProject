package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.repository.DepartementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementServiceImp implements IDepartementService{


    DepartementRepository departementRepository;

    @Override
    public Departement getDepartementById(int id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(int id) {
        departementRepository.deleteById(id);
    }


}
