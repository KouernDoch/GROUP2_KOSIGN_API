package com.example.jpatesting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user_tb")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "phoneNumber")

    private String phoneNumber;
    @Column(name = "address")

    private String address;
    @Column(name = "gender")

    private String gender;
    @Column(name = "dateOfBirth")

    private Date dateOfBirth;

    public UserEntity(Long id, String username, String phoneNumber, String address, String gender, Date dateOfBirth) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public UserEntity(){}
}
