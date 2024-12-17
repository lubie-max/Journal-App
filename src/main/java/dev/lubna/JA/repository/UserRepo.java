package dev.lubna.JA.repository;

import dev.lubna.JA.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<Users, UUID> {

    Users findByUsername(String username);


}
