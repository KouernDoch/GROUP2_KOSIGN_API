package com.example.jpatesting.controller;

import com.example.jpatesting.common.ResponseData;
import com.example.jpatesting.common.ResponseMessage;
import com.example.jpatesting.service.Impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/upload")
public class FileController {
    @Autowired
    private FileServiceImpl fileServiceImpl;
    @PostMapping(value = "/api/v1/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileServiceImpl.saveFile(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("/api/v1/files")
    public ResponseEntity<List<ResponseData>> getListFiles() {
        List<ResponseData> files = fileServiceImpl.getAllFiles().map(fileData -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/v1/files/")
                    .path(fileData.getId())
                    .toUriString();

            return new ResponseData(
                    fileData.getName(),
                    fileDownloadUri,
                    fileData.getType());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
