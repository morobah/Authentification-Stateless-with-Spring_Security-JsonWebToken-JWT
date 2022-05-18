package com.example.secservice.sec.repo;

import com.example.secservice.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUSerRepository  extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
