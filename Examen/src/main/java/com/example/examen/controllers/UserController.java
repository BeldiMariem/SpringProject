package com.example.examen.controllers;

import com.example.examen.entities.Project;
import com.example.examen.entities.Sprint;
import com.example.examen.entities.User;
import com.example.examen.services.IServiceProject;
import com.example.examen.services.IServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    IServiceUser iUserService;
    IServiceProject iServiceProject;

    @PostMapping("/adduser")
    @ResponseBody
    public User addUser(@RequestBody User u){
        return iUserService.addUser(u);
    }
    @PostMapping("/addProject")
    @ResponseBody
    public Project addProject(@RequestBody Project project){
        return iServiceProject.addProject(project);
    }
    @PutMapping ("/assignProjectToDeveloper/{idP}/{idD}")
    public void assignProjectToDeveloper(@PathVariable int idP, @PathVariable int idD){
        iServiceProject.assignProjectToDeveloper(idP,idD);}

    @PutMapping("/assignProjectToScrumMaster/{idP}/{fName}/{lName}")
    public void assignProjectToScrumMaster(@PathVariable int idP,@PathVariable String fName,@PathVariable String lName){
        iServiceProject.assignProjectToScrumMaster(idP,fName,lName);
    }


    @GetMapping("/getProjectsByScrumMaster/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable String fName, @PathVariable String lName){
        return iServiceProject.getProjectsByScrumMaster(fName,lName);
    }

    @PutMapping("/addSprintAndAssignToProject/{idP}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable int idP){
        iServiceProject.addSprintAndAssignToProject(sprint,idP);
    }


}
