package com.aixmplugin.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

import com.aixmplugin.demo.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long> {
    public List<Project> findAll();
}
