package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ivan on 09.06.18.
 */
@Entity(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id_user")
    private String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "pass_hash")
    private String passHash;

    public UserEntity(String userId, String name, String surname, String passHash) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.passHash = passHash;
    }

    public UserEntity() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passHash='" + passHash + '\'' +
                '}';
    }
}
