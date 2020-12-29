package com.practice.todoapp.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name="userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name="username", nullable = false)
    private String userName;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="userpassword", nullable = false)
    private String userPassword;
    @Column(name="categorization")
    private String categorization;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCategorization() {
        return categorization;
    }

    public void setCategorization(String categorization) {
        this.categorization = categorization;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", categorization='" + categorization + '\'' +
                '}';
    }
}
