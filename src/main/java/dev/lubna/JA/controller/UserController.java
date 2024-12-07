package dev.lubna.JA.controller;


import dev.lubna.JA.model.User;
import dev.lubna.JA.repository.UserRepo;
import dev.lubna.JA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    public  ResponseEntity<?> getAllUsers(){
       List<User> users = userService.getAllUsers();
       return new   ResponseEntity(users , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String res = userService.createUser(user);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{username}")
    public  ResponseEntity<?>  updateUser(@PathVariable String username , @RequestBody User user){

        String res = userService.updateUser(user , username);

        return  new ResponseEntity<>(res , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public  ResponseEntity<?> deleteUser(@PathVariable String username){
        String res = userService.deleteUser(username);
        return  new ResponseEntity<>(res , HttpStatus.OK);
    }



}
