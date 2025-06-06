package fr.diginamic.springsecurity.services;

import fr.diginamic.springsecurity.models.UserApp;
import fr.diginamic.springsecurity.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    @Autowired
    UserAppRepository repo;

    public void createUser(String username, String password) {
        repo.save(
                new UserApp(
                        username,
                        password
                )
        );
    }
}
