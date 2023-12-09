package com.example.dad_assembly_vote.usecases.services.impl;

import com.example.dad_assembly_vote.entity.User;
import com.example.dad_assembly_vote.infrastructure.repositories.UserRepository;
import com.example.dad_assembly_vote.usecases.storage.StorageStrategy;
import com.example.dad_assembly_vote.usecases.users.IUserService;
import com.example.dad_assembly_vote.usecases.users.addpicture.AddPictureIn;
import com.example.dad_assembly_vote.usecases.users.register.UserIn;
import com.example.dad_assembly_vote.usecases.users.register.UserOut;
import com.example.dad_assembly_vote.utils.QueryIn;
import com.example.dad_assembly_vote.utils.Queryable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final StorageStrategy storageStrategy;


    public UserServiceImpl(UserRepository userRepository, StorageStrategy storageStrategy) {
        this.userRepository = userRepository;
        this.storageStrategy = storageStrategy;
    }

    @Override
    public UserOut register(UserIn userIn) {

        var name = userIn.name();
        var user = userRepository.save(new User(name));
        return new UserOut(user.getId(), user.getName(), user.getPhotoUrl());
    }

    @Override
    public UserOut addPicture(AddPictureIn pictureIn) {
        var user = userRepository.findById(pictureIn.id());
        if (user.isPresent()) {
            var userOut = user.get();
            var output = storageStrategy.insertFileAtFolder("user", pictureIn.file());
            userOut.setPhotoUrl(output);
            userRepository.save(userOut);
            return UserOut.fromUser(userOut);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "user not found"
        );
    }

    @Override
    public Queryable<UserOut> query(QueryIn query) {
        var pageConfig = PageRequest.of(query.page(), query.perPage());
        var page = userRepository.findAllByNameContainingIgnoreCase(query.query(), pageConfig);
        return new Queryable<>(page.getNumber(), (int) userRepository.count(), query.perPage(),
                page.getContent().stream().map(UserOut::fromUser).toList());
    }

}
