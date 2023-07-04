package com.aixmplugin.demo;


import java.util.Arrays;

//import java.util.Arrays;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aixmplugin.demo.entities.Investor;
import com.aixmplugin.demo.entities.Project;
import com.aixmplugin.demo.repository.InvestorRepository;
import com.aixmplugin.demo.repository.ProjectRepository;

@SpringBootApplication
public class AixmPluginApplication {
	@Autowired
	InvestorRepository investorRepo;
	@Autowired
	ProjectRepository projectRepo;

	public static void main(String[] args) {
		SpringApplication.run(AixmPluginApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			Investor inv1 = new Investor("berri", "alaeddine","password", "email");
			Investor inv2 = new Investor("sam", "bibi","password2", "email2");
			
			Project pro1 = new Project("project one","val de marn","12000","not started","some description");
			Project pro2 = new Project("project two","paris lune","13000","completed","some description of the seconde project");
			
			pro1.addInvestor(inv1);
			pro2.addInvestor(inv2);

			inv1.setProjects(Arrays.asList(pro1));
			inv2.setProjects(Arrays.asList(pro2));
			
			// inv1.addProject(pro1);
			// inv2.addProject(pro2);
			
			// Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
			
			
			// // Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"

			// // // need to set both sides of the relationship manually

			// pro1.addInvestor(inv1);
			// pro2.addInvestor(inv2);
		
			// // pro1.addEmployee(emp1);
			// // pro1.addEmployee(emp2);
			// // pro2.addEmployee(emp3);
			// // pro3.addEmployee(emp1);
			// // pro4.addEmployee(emp1);
			// // pro4.addEmployee(emp3);
            //    //pro1.addInvestor(inv1);
			   
			
			// // // need to set both sides of the relationship manually

			
			// // emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
			// // emp2.setProjects(Arrays.asList(pro1));
			// // emp3.setProjects(Arrays.asList(pro2, pro4));
              

			// //inv1.setListofProject(Arrays.asList(pro1, pro2));
			// //inv2.setListofProject(Arrays.asList(pro1, pro2));
			// //pro1.setListofInvestor(Arrays.asList(inv1));
			
			// // // save employees in database

			// // empRepo.save(emp1);
			// // empRepo.save(emp2); 
			// // empRepo.save(emp3); 
			// // empRepo.save(emp4);
			// // empRepo.save(emp5); 
			// // empRepo.save(emp6); 
			// // empRepo.save(emp7); 
			// // empRepo.save(emp8); 
			// // empRepo.save(emp9);

			
			// // // save projects in database

			// // projRepo.save(pro1);
			// // projRepo.save(pro2); 
			// // projRepo.save(pro3); 
			// // projRepo.save(pro4);
			// investorRepo.save(inv1);
			// investorRepo.save(inv2);
			// projectRepo.save(pro1);
			// projectRepo.save(pro2);
			// inv1.addProject(pro1);
			// inv2.addProject(pro2);
	
			inv1 = investorRepo.save(inv1);
			inv2 = investorRepo.save(inv2);


	
			// pro1.addInvestor(inv1);
			// pro2.addInvestor(inv2);
	
			projectRepo.save(pro1);
			projectRepo.save(pro2);
			

			
		};
		
	}

}
