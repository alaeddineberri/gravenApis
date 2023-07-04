package com.aixmplugin.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aixmplugin.demo.entities.Investor;
import com.aixmplugin.demo.repository.InvestorRepository;

@RestController
@RequestMapping("/user")
public class InvestorController {

    @Autowired
    InvestorRepository investorRepo;
    
    @GetMapping("/all")
    public List<Investor> getAllUser(){
        return investorRepo.findAll() ;
    }

    @GetMapping("/{id}")
    public Investor getProjectById(Long id){
       return investorRepo.findById(id).get();
    }

    @PostMapping("/save")
    public Investor saveUser(@RequestBody  Investor investor){
        return investorRepo.save(investor);
    }
}
