package com.example.jpatesting.repository;

import com.example.jpatesting.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity,Long> {
//    @Query(value = "SELECT * FROM mt_file WHERE filename = :fileName", nativeQuery = true)
//    FileEntity GetFileByName(@Param("fileName") String filename);
}
