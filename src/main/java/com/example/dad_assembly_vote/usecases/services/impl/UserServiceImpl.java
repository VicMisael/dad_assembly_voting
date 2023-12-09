package com.example.dad_assembly_vote.usecases.services.impl;

import com.example.dad_assembly_vote.entity.User;
import com.example.dad_assembly_vote.usecases.users.IUserService;
import com.example.dad_assembly_vote.usecases.users.addpicture.AddPictureIn;
import com.example.dad_assembly_vote.usecases.users.register.UserIn;
import com.example.dad_assembly_vote.usecases.users.register.UserOut;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public UserOut register(UserIn userIn) {
        return null;
    }

    @Override
    public UserOut addPicture(AddPictureIn pictureIn) {
        return null;
    }

    @Override
    public Queryable<User> query(QueryIn query) {
        return null;
    }

}
