package com.example.dad_assembly_vote.usecases.users;

import com.example.dad_assembly_vote.entity.User;
import com.example.dad_assembly_vote.usecases.users.addpicture.AddPictureIn;
import com.example.dad_assembly_vote.usecases.users.register.UserIn;
import com.example.dad_assembly_vote.usecases.users.register.UserOut;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;

public interface IUserService {
    public UserOut register(UserIn userIn);

    public UserOut addPicture(AddPictureIn pictureIn);

    public Queryable<UserOut> query(QueryIn query);
}
