package com.fsse2502.fsse2502projectbackend.data.user.entity;

import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name = "user", indexes = @Index(columnList = "email"))
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false,  unique = true)
    private String firebaseUid;

    public UserEntity() {
    }

    public UserEntity(FirebaseUserData firebaseUserData) {
        this.email = firebaseUserData.getEmail();
        this.firebaseUid = firebaseUserData.getFirebaseUid();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
