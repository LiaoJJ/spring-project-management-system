package com.example.pma;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PmaApplication {

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    EmployeeRepository empRepo;

    public static void main(String[] args) {
        SpringApplication.run(PmaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
      return arg -> {

      };
    }

}
