package com.example.examen.services;

import com.example.examen.entities.Project;
import com.example.examen.entities.Sprint;
import com.example.examen.entities.User;
import com.example.examen.repository.ProjectRepository;
import com.example.examen.repository.SprintRepository;
import com.example.examen.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceProjectImp implements IServiceProject{
    UserRepository userRepository;
    ProjectRepository projectRepository;
    SprintRepository sprintRepository;

    @Override
    @Transactional
    public Project addProject(Project project) {
        List<Sprint> Sprints = new ArrayList<>(project.getSprints());
        for (Sprint s: Sprints) {
            s.setProject(project);
            sprintRepository.save(s);
        }
        return projectRepository.save(project);
    }

    @Override
    public void assignProjectToDeveloper(int projectId, int devId) {
        Project project =projectRepository.findById(projectId).orElse(null);
        User user =userRepository.findById(devId).orElse(null);
        user.getProjects().add(project);
        userRepository.save(user);
    }

    @Override
    public void assignProjectToScrumMaster(int idP, String fName, String lName) {
        Project project = projectRepository.findById(idP).orElse(null);
        User u = userRepository.findByFNameAndLName(fName,lName);
        u.getProjects().add(project);
        userRepository.save(u);
    }
    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User user = userRepository.findByFNameAndLName(fName,lName);
        List<Project> listProjects = new ArrayList<>(user.getProjects());
        return listProjects;
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idP) {
        Project project = projectRepository.findById(idP).orElse(null);
        sprint.setProject(project);
        sprintRepository.save(sprint);
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *" )
    public void getProjectsCurrentSprints() {
        List<Sprint> sprints = sprintRepository.SprintDate(new Date(System.currentTimeMillis()));
        log.info("Sprints : ");
        for (Sprint s:sprints) {
            log.info("Description : " +s.getDescription()+"\n startDate : "+s.getStartDate());
        }
    }


}
