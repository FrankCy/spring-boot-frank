package com.frank.sb.js.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "jd_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    // getter and setter...
}