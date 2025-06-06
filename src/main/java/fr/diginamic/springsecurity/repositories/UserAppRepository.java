package fr.diginamic.springsecurity.repositories;

import fr.diginamic.springsecurity.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {

    public Optional<UserApp> findByEmail(String email);
}
