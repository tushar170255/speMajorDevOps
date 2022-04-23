package com.hero.hero.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(unique = true)
    private String usrName;
    @NotNull
    private String password;
    @NotNull
    private String firstName;

    private String lastName;
    @NotNull
    private String sex;
    private String email;
    @NotNull
    private String phone;
    private String address;
    private String image;



}
