package com.example.dad_assembly_vote.usecases.storage;

import org.springframework.web.multipart.MultipartFile;


public interface StorageStrategy {
     String insertFileAtFolder(String foldername, MultipartFile file);

     boolean deleteFile(String filename);

    public String getUrl(String filename);

}