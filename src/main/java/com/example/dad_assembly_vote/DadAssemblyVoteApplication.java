package com.example.dad_assembly_vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DadAssemblyVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DadAssemblyVoteApplication.class, args);
    }

}
