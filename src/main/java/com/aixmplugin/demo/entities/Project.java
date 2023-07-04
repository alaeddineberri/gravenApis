package com.aixmplugin.demo.entities;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Project {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	private String name;
	private String state;
	private String description;
    private String price;
    private String localization;
    @ManyToMany(cascade= {CascadeType.DETACH , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST },fetch = FetchType.LAZY)
    @JoinTable(
    name = "project_user",
    joinColumns = @JoinColumn(name="project_id"),
    inverseJoinColumns = @JoinColumn(name="Investor_id")
    )
    @JsonIgnore
    List<Investor> investors;


    
    public List<Investor> getInvestors() {
        return investors;
    }
    public void setInvestors(List<Investor> investors) {
        this.investors = investors;
    }
    public Project(String name,String price,String localization, String state, String description) {
        this.name = name;
        this.localization=localization;
        this.price=price;
        this.state = state;
        this.description = description;
       
    }
    public Project(){

    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    
    public String getLocalization() {
        return localization;
    }
    public void setLocalization(String localization) {
        this.localization = localization;
    }
    
    public Long getProjectId() {
        return projectId;
    }
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
     
    public void addInvestor(Investor investor){
        if(this.investors ==null){
            this.investors = new ArrayList<>();
        }
        else{
            this.investors.add(investor);
        }
    }
 
   

    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", name=" + name + ", state=" + state + ", description="
                + description + ", price=" + price + ", localization=" + localization + "]";
    }
    
    
    

}
