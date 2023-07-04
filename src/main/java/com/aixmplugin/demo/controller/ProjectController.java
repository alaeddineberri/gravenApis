package com.aixmplugin.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aixmplugin.demo.entities.Project;
import com.aixmplugin.demo.repository.ProjectRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepo;
    @GetMapping("/all")
    public List<Project> getAllProject(){
        return projectRepo.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(Long id){
       return projectRepo.findById(id).get();
    }
    @PostMapping("/save")
    public Project saveProject(@RequestBody Project project){
     return projectRepo.save(project);
    }
}
