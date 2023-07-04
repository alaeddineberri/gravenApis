package com.aixmplugin.demo.entities;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import java.util.ArrayList;

//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;

@Entity
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long InvestorId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(cascade= {CascadeType.DETACH , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST },fetch = FetchType.LAZY)
    @JoinTable(
        name = "project_user",
        joinColumns = @JoinColumn(name="investor_id"),
        inverseJoinColumns = @JoinColumn(name="project_id")
        )
    @JsonIgnore
    private List<Project> projects;
    

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Investor(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
  
     
    public Investor(){

    }
  
    public long getInvestorId() {
        return InvestorId;
    }

    public void setInvestorId(long investorId) {
        InvestorId = investorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Investor [InvestorId=" + InvestorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + "]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addProject(Project project){
        if(this.projects==null){
            this.projects = new ArrayList<>();
        }
        else{
            this.projects.add(project);
        }
    }

}
