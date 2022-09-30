package com.example.demo_spring.services;

import com.example.demo_spring.dto.response.FileInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file.storage.path}")
    public String fileStorePath;

    @SneakyThrows
    public FileInfo add(MultipartFile file) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        file.transferTo(new File(fileStorePath + fileName));
        return new FileInfo("serverUrl", fileName, file.getSize());
    }

}
