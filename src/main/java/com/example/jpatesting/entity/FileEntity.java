package com.example.jpatesting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mt_file")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url")
    private String url;

    @Column(name = "filename")
    private String fileName;

    public FileEntity(){}

    public FileEntity(String url,String fileName) {
        this.url = url;
        this.fileName = fileName;
    }
}
