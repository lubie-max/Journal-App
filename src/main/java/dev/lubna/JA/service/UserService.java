package dev.lubna.JA.service;

import dev.lubna.JA.model.Users;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService  {

    @Autowired
    public  UserRepo userRepo;

    private  static  final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public  void  saveUser(Users users){
        userRepo.save(users);
    }

    public List<Users> getAllUsers(){
        return  userRepo.findAll();
    }

    public String getUserInfo(){
        return  "It works for now !!" ;
    }


    // Extra

    public  boolean createNewUser(Users users){
        Users existingUsers = userRepo.findByUsername(users.getUsername());
        if (existingUsers == null){
            return  false;
        }

        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepo.save(users);
        return  true;

    }

    public  boolean createUser(Users users){
        Users existingUsers = userRepo.findByUsername(users.getUsername());
        if (existingUsers == null){
            return  false;
        }

        userRepo.save(users);
        return  true;

    }




    public Optional<Users> getUserByName(String username){
        Users isUsersExist = userRepo.findByUsername(username);

        if (isUsersExist != null){
            return Optional.ofNullable(userRepo.findByUsername(username));
        }

        return Optional.empty();
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


    @Transactional
    public  Boolean  deleteUser(String username){

        Users users = userRepo.findByUsername(username);

        if (users != null){
            userRepo.deleteById(users.getId());

            return  true;
        }

        return  false;
    }


    public  String updateUser(Users users, String username){

        try {
            Users isExistingUsers = userRepo.findByUsername(username);
            if (isExistingUsers != null){

                isExistingUsers.setPassword(users.getPassword());
//                users.setPassword(users.getPassword());
                userRepo.save(isExistingUsers);
                return "password has been updated !!";
            }
            return  "Not a valid users !!";
        }
        catch (Exception e){
          e.printStackTrace();
        }
        return  null;

    }

}
