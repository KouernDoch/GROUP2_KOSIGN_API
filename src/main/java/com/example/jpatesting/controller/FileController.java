package com.example.jpatesting.controller;

import com.example.jpatesting.common.FileResponse;
import com.example.jpatesting.entity.FileEntity;
import com.example.jpatesting.service.Service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fileView")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFiles(@RequestParam("files") List<MultipartFile> files) throws IOException {
        List<String> fileUrl = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = fileService.Uplaodfile(file);
            String url = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .replacePath("/api/v1/fileView/" + fileName)
                    .toUriString();
            FileEntity fileEntity = new FileEntity(url,fileName);
            fileService.InsertFile(fileEntity);
            fileUrl.add(url);
        }
        return ResponseEntity.ok().body(new FileResponse<>(
                "Upload files successfully",
                201,
                fileUrl
        ));
    }
    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws IOException {
        Resource file=fileService.getFile(fileName);
//        String fileUrl = ServletUriComponentsBuilder.fromCurrentRequestUri()
//                .replacePath("/api/v1/file/" + fileName)
//                .toUriString();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file);
    }
}
