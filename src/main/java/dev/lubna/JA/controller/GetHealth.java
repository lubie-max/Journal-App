package dev.lubna.JA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetHealth {

    @GetMapping("/check")
    public  String getHealth(){
        return "Everything is ok!!";
    }

}
