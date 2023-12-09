package com.example.dad_assembly_vote.infrastructure.s3;

import com.example.dad_assembly_vote.usecases.storage.StorageStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Component
public class S3StorageStrategy implements StorageStrategy {

    private final S3Client s3Client;
    private final String bucketName;

    public S3StorageStrategy(@Value("${dad.bucketname}") String bucketName) {
        this.bucketName = bucketName;
        this.s3Client = S3Client.builder()
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .region(Region.US_EAST_1)
                .build();
    }

    @Override
    public String insertFileAtFolder(String foldername, MultipartFile file) {
        String key = foldername + "/" + file.getOriginalFilename();
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();
            s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));
            return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toExternalForm();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteFile(String filename) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .build();
        s3Client.deleteObject(deleteObjectRequest);
        return true;

    }

    @Override
    public String getUrl(String filename) {
        return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(filename)).toExternalForm();
    }
}
