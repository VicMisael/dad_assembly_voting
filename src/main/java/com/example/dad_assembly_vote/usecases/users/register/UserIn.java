package com.example.dad_assembly_vote.usecases.users.register;

import org.springframework.web.multipart.MultipartFile;

public record UserIn(
        String name,
        MultipartFile multipartFile
) {
}
