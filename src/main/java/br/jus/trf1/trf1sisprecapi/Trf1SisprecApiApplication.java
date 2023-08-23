package br.jus.trf1.trf1sisprecapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class Trf1SisprecApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Trf1SisprecApiApplication.class, args);
    }

}
