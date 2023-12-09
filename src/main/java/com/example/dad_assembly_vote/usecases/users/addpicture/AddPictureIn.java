package com.example.dad_assembly_vote.usecases.users.addpicture;

import org.springframework.web.multipart.MultipartFile;

public record AddPictureIn(Long id, MultipartFile file) {
}
