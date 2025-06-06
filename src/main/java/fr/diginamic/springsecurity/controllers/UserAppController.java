package fr.diginamic.springsecurity.controllers;

import fr.diginamic.springsecurity.models.UserApp;
import fr.diginamic.springsecurity.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-app")
public class UserAppController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserApp userApp) throws Exception {
        customUserDetailsService.createUser(
                userApp.getEmail(),
                userApp.getPassword()
        );
        return "Utilisateur créé";
    }
}
