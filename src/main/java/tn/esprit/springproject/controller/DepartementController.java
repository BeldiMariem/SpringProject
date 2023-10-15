package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.services.IDepartementService;

import java.util.List;


@RestController
@AllArgsConstructor
public class DepartementController {


    IDepartementService iDepartementService;
    DepartementRepository departementRepository;

    @GetMapping("/getAllDepartements")
    public List<Departement> getAllDepartements(){
        return  iDepartementService.getAllDepartements();
    }

    @PostMapping("/addDepartement")
    @ResponseBody
    public Departement addDepartement(@RequestBody Departement d){
        return iDepartementService.addDepartement(d);
    }

    @PutMapping("/updateDepartement")
    @ResponseBody
    public Departement updateContrat(@RequestBody Departement d){
        return iDepartementService.updateDepartement(d);
    }

    @DeleteMapping("/deleteDepartement/{id}")
    public void deleteDepartement(@PathVariable("id") int id){
        iDepartementService.deleteDepartement(id);
    }

    @GetMapping("/getDepartementById/{id}")
    public Departement getDepartementByID(@PathVariable("id") int id){
        return iDepartementService.getDepartementById(id);
    }

    @GetMapping("/getDepatmentsByEtudiantOption/{op}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable("op") Option op){
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }

}
