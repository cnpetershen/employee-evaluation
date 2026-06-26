package com.peter.smartmedicalserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



    @RestController
    @RequestMapping("/upload")
    public class FileUploadController {

        private final String UPLOAD_DIR = "./uploads/";

        @PostMapping
        public String uploadFile(@RequestParam("file") MultipartFile file) {
            if (file.isEmpty()) {
                return "Please select a file to upload";
            }

            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
                Files.write(path, bytes);

                return "File uploaded successfully: " + file.getOriginalFilename();
            } catch (IOException e) {
                e.printStackTrace();
                return "File upload failed";
            }
        }
}
