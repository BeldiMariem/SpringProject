package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.repository.EtudiantRepository;
import tn.esprit.springproject.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {


    IEtudiantService iEtudiantService;
    EtudiantRepository etudiantRepository;

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> getAllEtudiants(){
        return  iEtudiantService.getAllEtudiants();
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.updateEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable("id") int id){
        iEtudiantService.deleteEtudiant(id);
    }

    @GetMapping("/getEtudiantById/{id}")
    public Etudiant getEtudiantByID(@PathVariable("id") int id){
        return iEtudiantService.getEtudiantById(id);
    }

    @GetMapping("/getEtudiantByprenom/{prenom}")
    public List<Etudiant> findByPrenomEContains(@PathVariable("prenom") String prenom){
        return iEtudiantService.findByPrenomEContains(prenom);
    }

    @GetMapping("/getEtudiantsByThematique/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique (@PathVariable("thematique") String thematique){
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @PutMapping("/UpdateOptionEtudiant/{op}/{idEtudiant}")
    public void updateEtudiantByOption(@PathVariable("op") Option op ,@PathVariable("idEtudiant") int idEtudiant){
        etudiantRepository.updateEtudiantByOption(op,idEtudiant);
    }

    @PutMapping("/assignEtudiantToDepartement/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable("etudiantId") int etudiantId,@PathVariable("departementId") int departementId){
        iEtudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @PostMapping("/addAndassignEtudiantToEquipeAndContrat/{idContrat}/{idEquipe}")
    @ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") int idContrat,@PathVariable("idEquipe") int idEquipe){
        return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer idDepartement){
        return iEtudiantService.getEtudiantsByDepartement(idDepartement);
    }

}
