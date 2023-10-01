package com.example.jpatesting.service.Service;

import com.example.jpatesting.entity.FileEntity;
import com.example.jpatesting.entity.UserEntity;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {
    FileEntity InsertFile(FileEntity fileEntity);
//    FileEntity GetFileByName(String filename);
    String Uplaodfile(MultipartFile file) throws IOException;

    Resource getFile(String fileName) throws IOException;
}
