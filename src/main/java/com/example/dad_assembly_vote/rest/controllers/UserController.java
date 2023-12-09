package com.example.dad_assembly_vote.rest.controllers;

import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.usecases.users.register.UserIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {
    @PostMapping
    public PautaOut RegisterUser(UserIn user) {
        return null;
    }

    public void AddPicture(){

    }
}
