package com.hero.hero.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Needy")
@Getter
@Setter
@NoArgsConstructor
public class Needy  {
    @Id @NotNull @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
     @NotNull @Column(unique=true)

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

    private  java.util.Date birthday;
    @NotNull
    private Long  age;
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(
            name = "hero_needy_prev",
            joinColumns = {@JoinColumn(name = "needy_id")},
            inverseJoinColumns = {@JoinColumn(name = "hero_id")})



    private List<Hero > heroes=new ArrayList<>(); ;



    @ManyToOne(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "hero_id_accept",referencedColumnName="id")
    @JsonIgnoreProperties("needyAccept")
    private Hero heroRequest;

    @ManyToOne(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "hero_id_pending",referencedColumnName="id")
    @JsonIgnoreProperties("needyPending")
    private Hero heroPending;




//    private long heroId;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }
    @NotNull
    private Long likes = Long.valueOf(0);
    @NotNull
    private Long dislikes = Long.valueOf(0);

    public boolean isDisable() {
        return disable;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislike) {
        this.dislikes = dislike;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(long like) {
        this.likes = like;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    @NotNull
    @ColumnDefault("false")
    private Boolean disable=false;
     @Nullable

    private String disability;
    @ColumnDefault("true")
    private Boolean enabled=true;
    private String image;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.usrName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }

//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.usrName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
    }
