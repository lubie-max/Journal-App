package dev.lubna.JA.service;

import dev.lubna.JA.model.User;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService  {

    @Autowired
    public  UserRepo userRepo;



    public  void  saveUser(User user){
        userRepo.save(user);
    }



    public List<User> getAllUsers(){
        return  userRepo.findAll();
    }


    public  boolean createUser(User user){


        if (userRepo.findByUsername(user.getUsername()).isPresent()){
            return  false;
        }

        userRepo.save(user);
        return  true;

    }

    public Optional<User> getUserByName(String username){
        boolean isUserExist = userRepo.findByUsername(username).isPresent();

        if (isUserExist){
            return   userRepo.findByUsername(username);
        }

        return null;
    }

    public  boolean deleteUser(UUID userid){

        try {
            if (userRepo.existsById(userid)){
                userRepo.deleteById(userid);
                return  true ;

            }
            else {
                return false;
            }
        }

       catch (Exception e){
            e.printStackTrace();
           return  false;

       }

    }


}
