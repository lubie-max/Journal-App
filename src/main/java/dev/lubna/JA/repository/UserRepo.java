package dev.lubna.JA.repository;

import dev.lubna.JA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);


}
