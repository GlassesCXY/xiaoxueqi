package com.example.xxqback.Util;


import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MinioUtil {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    public String getFileUrl(String path, String fileName) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(bucketName)
                            .object(path + "/" + fileName)
                            .method(Method.GET)
                            .expiry(2, TimeUnit.HOURS)
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
