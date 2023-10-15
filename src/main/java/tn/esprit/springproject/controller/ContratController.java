package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.services.IContratService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ContratController {


    IContratService iContratService;

    @GetMapping("/getAllContrats")
    public List<Contrat> getAllContrats(){
        return  iContratService.getAllContrats();
    }

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat c){
        return iContratService.addContrat(c);
    }

    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat c){
        return iContratService.updateContrat(c);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable("id") int id){
        iContratService.deleteContrat(id);
    }

    @GetMapping("/getContratById/{id}")
    public Contrat getContratByID(@PathVariable("id") int id){
        return iContratService.getContratById(id);
    }

    @PutMapping("/updateContratByEtudiant/{nomE}/{prenomE}")
    @ResponseBody
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE) {
        return iContratService.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/getNbrContratValide")
    public Integer nbContratsValides(@RequestParam Date startDate,@RequestParam Date endDate){
        return iContratService.nbContratsValides(startDate,endDate);
    }

    @GetMapping("/getContratsByMontant")
    public String getChiffreAffaireEntreDeuxDate(@RequestParam Date startDate,@RequestParam Date endDate){
        return iContratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }
}
