package com.hero.hero.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="Hero")
public class Hero {
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
    @NotNull
    private Long pincode;
    @NotNull
    private Long servicePincode;


    private java.util.Date birthday;
    @NotNull
    private long age;
    @NotNull
    private long task = 0;
    @NotNull @Column(unique=true)
    private  String aadhaar;
    @NotNull
    private String aadhaarImage;

    @NotNull
    private String otherIdentityImage;

    private boolean enabled = true;
    private String image;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "heroes")
    private List<Needy> needs=new ArrayList<>();
    @NotNull
    private Long likes = Long.valueOf(0);
    private Long dislikes = Long.valueOf(0);
    public List<Needy> getNeeds() {
        return needs;
    }
    @OneToMany(mappedBy = "heroRequest" , cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("heroRequest")
    private List<Needy> needyAccept=new ArrayList<Needy> ();

    @OneToMany(mappedBy = "heroPending" , cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("heroPending")
    private List<Needy> needyPending=new ArrayList<Needy> ();

//    @OneToMany(mappedBy = "heroCompleted" , cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//    @JsonIgnoreProperties("heroCompleted")
//    private List<Needy> needyCompleted=new ArrayList<Needy> ();



//  private List <Long> needyToAccept= Collections.synchronizedList(new ArrayList<Long> ());
    public Long getLikes() {

        return likes;
    }

    public void setLikes(long like) {
        this.likes = like;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislike) {
        this.dislikes = dislike;
    }
}