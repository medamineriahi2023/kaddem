package com.esprit.kaddem;

import com.esprit.kaddem.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KaddemApplication {
      public static void main(String[] args) {
        SpringApplication.run(KaddemApplication.class, args);
    }

}
