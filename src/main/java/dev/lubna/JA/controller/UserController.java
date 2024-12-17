package dev.lubna.JA.controller;


import dev.lubna.JA.model.Users;
import dev.lubna.JA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    public  ResponseEntity<?> getAllUsers(){
       List<Users> users = userService.getAllUsers();
       return new   ResponseEntity(users , HttpStatus.OK);
    }

    @GetMapping("/name")
    public  ResponseEntity<?> getUserDetails(){
        String Res = userService.getUserInfo() ;

            return  new ResponseEntity<>(Res, HttpStatus.OK);



    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        Boolean res = userService.createNewUser(users);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{username}")
    public  ResponseEntity<?>  updateUser(@PathVariable String username , @RequestBody Users users){

        String res = userService.updateUser(users, username);

        return  new ResponseEntity<>(res , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public  ResponseEntity<?> deleteUser(@PathVariable String username){
        boolean res = userService.deleteUser(username);
        if (res){

            return  new ResponseEntity<>("This user has been deleted successfully!" , HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong ! ", HttpStatus.BAD_REQUEST);

    }



}
