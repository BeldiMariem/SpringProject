package tn.esprit.springproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {


    IUniversiteService iUniversiteService;

    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites() {
        return iUniversiteService.getAllUniversites();
    }

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteService.updateUniversite(u);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite(@PathVariable("id") int id) {
        iUniversiteService.deleteUniversite(id);
    }

    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversiteByID(@PathVariable("id") int id) {
        return iUniversiteService.getUniversiteById(id);
    }

    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable("idUniversite") int idUniversite, @PathVariable("idDepartement") int idDepartement) {
        iUniversiteService.assignUniversiteToDepartement(idUniversite, idDepartement);
    }

    @GetMapping("/getDepartmentByUniversity/{idUniversite}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniversite) {
        return iUniversiteService.retrieveDepartementsByUniversite(idUniversite);
    }
}