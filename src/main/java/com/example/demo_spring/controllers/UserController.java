package com.example.demo_spring.controllers;

import com.example.demo_spring.dto.request.AuthenticationRequest;
import com.example.demo_spring.dto.request.UserRegisterRequest;
import com.example.demo_spring.dto.response.AuthenticationResponse;
import com.example.demo_spring.dto.response.FileInfo;
import com.example.demo_spring.dto.response.UserRegistrationResponse;
import com.example.demo_spring.services.FileService;
import com.example.demo_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private FileService fileService;

    @Autowired
    public UserController(UserService userService,
                          FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @PostMapping("/register")
    public UserRegistrationResponse register(@RequestBody UserRegisterRequest request) {
        return userService.register(request);

    }

    @GetMapping("/activate")
    public String activate(@RequestParam("token") String token) {
        return userService.activate(token);
    }

    @PostMapping(
            value = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity login(@RequestBody AuthenticationRequest request) {
        return  ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/upload-file")
    public ResponseEntity<FileInfo> addFile(@RequestPart(name = "file")final MultipartFile file){
        return ResponseEntity
                .status(200)
                .body(fileService.add(file));
    }


    @GetMapping("/file-download")
    public ResponseEntity<Resource> getFile(@RequestParam(name = "fileName") String fileName) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        FileInputStream fileInputStream = new FileInputStream(fileService.fileStorePath + fileName);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileInputStream.available())
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(fileInputStream));
    }



    @GetMapping("/index")
    public String test(){
        return "index text";
    }
}
