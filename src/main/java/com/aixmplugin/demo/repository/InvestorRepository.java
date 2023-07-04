package com.aixmplugin.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

import com.aixmplugin.demo.entities.Investor;

public interface InvestorRepository extends CrudRepository<Investor,Long> {
    public List<Investor> findAll();
}
