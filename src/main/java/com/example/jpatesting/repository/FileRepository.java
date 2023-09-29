package com.example.jpatesting.repository;

import com.example.jpatesting.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, String> {

}
