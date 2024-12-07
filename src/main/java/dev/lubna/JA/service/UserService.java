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


    public  String  deleteUser(String username){

        Optional<User> user = userRepo.findByUsername(username);

        if (user.isPresent()){
            userRepo.deleteById(user.get().getId());

            return  "User has been deleted !!";
        }

        return  "Something went wrong !!";
    }


    public  String updateUser(User user , String username){

        try {
            Optional<User> isExistingUser = userRepo.findByUsername(username);
            if (isExistingUser.isPresent()){

                isExistingUser.get().setPassword(user.getPassword());
//                user.setPassword(user.getPassword());
                userRepo.save(isExistingUser.get());
                return "password has been updated !!";
            }
            return  "Not a valid user !!";
        }
        catch (Exception e){
          e.printStackTrace();
        }
        return  null;

    }

}
