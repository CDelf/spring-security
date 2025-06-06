package fr.diginamic.springsecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/public")
    public String getHelloPublic() throws Exception {
        return "Hello utilisateur non connecté!";
    }

    @GetMapping("/private")
    public String getHelloPrivate(Authentication authentication) throws Exception {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        return "Hello utilisateur connecté! " + username;
    }

    @PostMapping("/public")
    public String hello() {
        return "Public Hello";
    }
}
