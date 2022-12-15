package com.example.examen.services;

import com.example.examen.entities.Project;
import com.example.examen.entities.Sprint;
import com.example.examen.entities.User;

import java.util.List;

public interface IServiceProject {
    public Project addProject(Project project);
    public void assignProjectToDeveloper(int projectId,int devId);
    public void assignProjectToScrumMaster(int projectId,String fName,String iName);
    public List<Project> getProjectsByScrumMaster(String fName, String lName);
    public void addSprintAndAssignToProject(Sprint sprint, int idProject);
    public void getProjectsCurrentSprints();



}
