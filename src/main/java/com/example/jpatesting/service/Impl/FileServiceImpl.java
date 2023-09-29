package com.example.jpatesting.service.Impl;

import com.example.jpatesting.entity.FileEntity;
import com.example.jpatesting.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service

public class FileServiceImpl {
@Autowired
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileEntity saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileEntity fileData  = new FileEntity(fileName,file.getContentType());
        return fileRepository.save(fileData);
    }
    public FileEntity getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<FileEntity> getAllFiles() {
        return fileRepository.findAll().stream();
    }


}
