package com.example.dad_assembly_vote.rest.controllers;

import com.example.dad_assembly_vote.usecases.users.IUserService;
import com.example.dad_assembly_vote.usecases.users.addpicture.AddPictureIn;
import com.example.dad_assembly_vote.usecases.users.register.UserIn;
import com.example.dad_assembly_vote.usecases.users.register.UserOut;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserOut RegisterUser(UserIn user) {
        return userService.register(user);
    }

    @GetMapping
    public Queryable<UserOut> getPautas(@RequestParam Optional<String> query,
                                        @RequestParam Optional<Integer> page,
                                        @RequestParam Optional<Integer> perPage) {
        int perPageFiltered = perPage.orElse(10);
        int pageFiltered = page.orElse(0);
        var queryIn = new QueryIn(query.orElse(""), Math.max(pageFiltered, 0), perPageFiltered <= 0 ? 10 : perPageFiltered);
        return userService.query(queryIn);
    }

    @PostMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public UserOut UploadImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
       return userService.addPicture(new AddPictureIn(id, file));
    }

}
