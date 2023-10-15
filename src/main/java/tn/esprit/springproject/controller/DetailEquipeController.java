package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.services.IDetailEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DetailEquipeController {

    IDetailEquipeService iDetailEquipeService;

    @GetMapping("/getAllDetailEquipe")
    public List<DetailEquipe> getAllDetailEquipe(){
        return  iDetailEquipeService.getAllDetailEquipe();
    }

    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe d){
        return iDetailEquipeService.addDetailEquipe(d);
    }

    @PutMapping("/updateDetailEquipe")
    @ResponseBody
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe d){
        return iDetailEquipeService.updateDetailEquipe(d);
    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    public void deleteDetailEquipe(@PathVariable("id") int id){
        iDetailEquipeService.deleteDetailEquipe(id);
    }

    @GetMapping("/getDetailEquipeById/{id}")
    public DetailEquipe getDetailEquipeByID(@PathVariable("id") int id){
        return iDetailEquipeService.getDetailEquipeById(id);
    }

    @GetMapping("/getByThematique/{thematique}")
    public List<DetailEquipe> findByThematiqueLike (@PathVariable("thematique") String thematique){
        return iDetailEquipeService.findByThematiqueLike(thematique);
    }
}
