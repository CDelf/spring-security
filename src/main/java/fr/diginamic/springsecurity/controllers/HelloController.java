package fr.diginamic.springsecurity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/public")
    public String getHelloPublic() throws Exception {
        return "hello you";
    }

    @GetMapping("/private")
    public String getHelloPrivate() throws Exception {
        return "hello darling";
    }

    @GetMapping("/me")
    public String userRoles(Authentication authentication) {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        return "Utilisateur connecté : " + username;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Zone réservée à l'admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userOnly() {
        return "Zone réservée à l'utilisateur";
    }


    @GetMapping("/say-hello/{name}")
    public String getHelloPrivate(@PathVariable String name) throws Exception {
        return "hello " + name;
    }

    @PostMapping("/public")
    public String hello() {
        return "Public Hello";
    }
}
