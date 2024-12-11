package dev.lubna.JA.controller;


import dev.lubna.JA.model.User;
import dev.lubna.JA.repository.UserRepo;
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
       List<User> users = userService.getAllUsers();
       return new   ResponseEntity(users , HttpStatus.OK);
    }

    @GetMapping("/name/{username}")
    public  ResponseEntity<?> getUserDetails(@PathVariable String username){
        Optional<User> userEn = userService.getUserByName(username);
        if(userEn.isPresent()){
            return  new ResponseEntity<>(userEn, HttpStatus.OK);

        }
        return  new ResponseEntity<>("No such user found !!" , HttpStatus.NOT_FOUND);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        Boolean res = userService.createUser(user);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{username}")
    public  ResponseEntity<?>  updateUser(@PathVariable String username , @RequestBody User user){

        String res = userService.updateUser(user , username);

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
