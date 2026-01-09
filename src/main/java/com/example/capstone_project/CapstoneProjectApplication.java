package com.example.capstone_project;

import com.example.capstone_project.entity.Roles;
import com.example.capstone_project.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapstoneProjectApplication implements CommandLineRunner{

    @Autowired
    RolesRepository rolesRepository;

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

    @Override
    public void run(String[] args)
    {
        if(rolesRepository.count()==0)
        {
            rolesRepository.save(new Roles(1, "ADMIN","UPLOAD,REVIEW,APPROVE"));
            rolesRepository.save(new Roles(2,"CREATOR","UPLOAD"));
            rolesRepository.save(new Roles(3,"REVIEWER","REVIEW"));
            rolesRepository.save(new Roles(4,"APPROVER","APPROVE"));
        }
    }

}
