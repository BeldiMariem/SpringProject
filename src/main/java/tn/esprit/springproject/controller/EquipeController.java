package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;
import tn.esprit.springproject.repository.EquipeRepository;
import tn.esprit.springproject.services.IEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {


    IEquipeService iEquipeService;
    EquipeRepository equipeRepository;

    @GetMapping("/getAllEquipes")
    public List<Equipe> getAllEquipes(){
        return  iEquipeService.getAllEquipes();
    }

    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe e){
        return iEquipeService.addEquipe(e);
    }

    @PutMapping("/updateEquipe")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe e){
        return iEquipeService.updateEquipe(e);
    }

    @DeleteMapping("/deleteEquipe/{id}")
    public void deleteEquipe(@PathVariable("id") int id){
        iEquipeService.deleteEquipe(id);
    }

    @GetMapping("/getEquipeById/{id}")
    public Equipe getEquipeByID(@PathVariable("id") int id){
        return iEquipeService.getEquipeById(id);
    }

    @GetMapping("/getEquipesByIdEtudiant/{idEtudiant}")
    public List<Equipe> findByEtudiantsIdEtudiant (@PathVariable("idEtudiant") Integer idEtudiant){
        return iEquipeService.findByEtudiantsIdEtudiant(idEtudiant);
    }

    @GetMapping("/getEquipesByDetailEquipe/{thematique}")
    public List<Equipe> findByDetailEquipeThematiqueContains (@PathVariable("thematique") String thematique){
        return iEquipeService.findByDetailEquipeThematiqueContains(thematique);
    }

    @GetMapping("/getEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull/{idEtudiant}")
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (@PathVariable("idEtudiant") Integer idEtudiant){
        return iEquipeService.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/getEtudiantsIdEtudiantAndEtudiantDepartementIdDepart/{idEtudiant}/{idDepart}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (@PathVariable("idEtudiant") Integer idEtudiant, @PathVariable("idDepart") Integer idDepart){
        return iEquipeService.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

    @GetMapping("/getEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau ,@PathVariable("thematique") String thematique){
       return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/DeleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        equipeRepository.deleteEquipeByNiveau(niveau);
    }


}
