package com.example.secservice.sec.sec.service;

import com.example.secservice.sec.entities.AppRole;
import com.example.secservice.sec.entities.AppUser;
import com.example.secservice.sec.repo.AppRoleRepository;
import com.example.secservice.sec.repo.AppUSerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUSerRepository appUSerRepository;
    private AppRoleRepository appRoleRepository;

    public AccountServiceImpl(AppUSerRepository appUSerRepository, AppRoleRepository appRoleRepository) {
        this.appUSerRepository = appUSerRepository;
        this.appRoleRepository = appRoleRepository;
    }


    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw=appUser.getPassword();
        return appUSerRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser=appUSerRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUSerRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {

        return appUSerRepository.findAll();
    }
}
