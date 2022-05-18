package com.example.secservice;

import com.example.secservice.sec.entities.AppRole;
import com.example.secservice.sec.entities.AppUser;
import com.example.secservice.sec.sec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SecServiceApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
        CommandLineRunner start(AccountService accountService){

            return args ->{
                accountService.addNewRole(new AppRole(null , "USER"));
                accountService.addNewRole(new AppRole(null , "ADMIN"));
                accountService.addNewRole(new AppRole(null , "CUSTOMER_MANAGER"));
                accountService.addNewRole(new AppRole(null , "PRODUCT_MANAGER"));
                accountService.addNewRole(new AppRole(null , "BILLS_MANAGER"));


                accountService.addNewUser(new AppUser(null, "user1","1234", new ArrayList<>()));
                accountService.addNewUser(new AppUser(null, "Mayatou","5432", new ArrayList<>()));
                accountService.addNewUser(new AppUser(null, "Tounkara","25896", new ArrayList<>()));
                accountService.addNewUser(new AppUser(null, "MamadouBa","1234", new ArrayList<>()));
                accountService.addNewUser(new AppUser(null, "Joseph","2589", new ArrayList<>()));
                accountService.addNewUser(new AppUser(null, "admin","12345", new ArrayList<>()));

                accountService.addRoleToUser("Mayatou" ,"USER");
                accountService.addRoleToUser("Tounkara","USER");
                accountService.addRoleToUser("Tounkara","ADMIN");
                accountService.addRoleToUser("Joseph","USER");
                accountService.addRoleToUser("Joseph","CUSTOMER_MANAGER");
                accountService.addRoleToUser("MamadouBa","CUSTOMER_MANAGER");
                accountService.addRoleToUser("MamadouBa","USER");
                accountService.addRoleToUser("admin","BILLS_MANAGER");
                accountService.addRoleToUser("admin","USER");
            };

    }

}
