package com.example.dad_assembly_vote.rest.controllers;

import com.example.dad_assembly_vote.usecases.pauta.register.PautaOut;
import com.example.dad_assembly_vote.usecases.users.IUserService;
import com.example.dad_assembly_vote.usecases.users.register.UserIn;
import com.example.dad_assembly_vote.usecases.users.register.UserOut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserOut RegisterUser(UserIn user) {
        return userService.register(user);
    }

    public void AddPicture() {

    }
}
