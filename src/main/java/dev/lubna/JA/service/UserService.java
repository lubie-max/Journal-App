package dev.lubna.JA.service;

import dev.lubna.JA.model.User;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserService  {

    @Autowired
    public  UserRepo userRepo;

    public List<User> getAllUsers(){
        return  userRepo.findAll();
    }

    public  String createUser(User user){


        if (userRepo.findByUsername(user.getUsername()).isPresent()){
            return  "User Already exists";
        }

        userRepo.save(user);
        return  "User created successfully !" ;

    }


}
