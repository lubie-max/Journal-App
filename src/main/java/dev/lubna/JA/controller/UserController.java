package dev.lubna.JA.controller;


import dev.lubna.JA.model.User;
import dev.lubna.JA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String res = userService.createUser(user);
        return  ResponseEntity.ok(res);
    }

}
