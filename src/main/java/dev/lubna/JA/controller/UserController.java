package dev.lubna.JA.controller;


import dev.lubna.JA.model.User;
import dev.lubna.JA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping("/all")
    public  ResponseEntity<List<User>> getUsers(){


        try {
            return (ResponseEntity<List<User>>) new ResponseEntity<>( userService.getAllUsers() , HttpStatus.OK);

        }
        catch (Exception e){
            return (ResponseEntity<List<User>>) ResponseEntity.badRequest();
        }
    }


    @GetMapping("/name/{user_name}")
    public ResponseEntity getByName(@PathVariable String user_name){
        try {
            return new ResponseEntity( userService.getUserByName(user_name) , HttpStatus.OK );
        }
        catch (Exception e){
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }



    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody User user){

        boolean isUserAdded = userService.createUser(user);
        if (isUserAdded){
           return new ResponseEntity(" User created successfully", HttpStatus.OK);
        }
        else {
            return  ResponseEntity.ok("User Already Exists!!");

        }
    }


    @DeleteMapping("/delete/{user_id}")
    public  ResponseEntity<String> deleteUser(@PathVariable UUID user_id){
        boolean isDeleted = userService.deleteUser(user_id) ;
        if (isDeleted){
            return ResponseEntity.ok().body("User deleted successfully !!");


        }

        return (ResponseEntity<String>) ResponseEntity.notFound();


    }

}
