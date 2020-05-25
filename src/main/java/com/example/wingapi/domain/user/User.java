package com.example.wingapi.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column
    private String userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String imageUri;

    @Column
    //@Enumerated(EnumType.STRING)
    private String role;


    @Builder
    private User(String userId, String name, String email, String imageUri, String role){
        this.userId=userId;
        this.name = name;
        this.email = email;
        this.imageUri = imageUri;
        this.role =role;
    }

}
