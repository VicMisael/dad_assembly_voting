package com.example.dad_assembly_vote.usecases.users.register;

import com.example.dad_assembly_vote.entity.User;

public record UserOut(
        Long id,
        String name,
        String url
) {
    public static UserOut fromUser(User user) {
        return new UserOut(user.getId(), user.getName(), user.getPhotoUrl());
    }

    ;
}
