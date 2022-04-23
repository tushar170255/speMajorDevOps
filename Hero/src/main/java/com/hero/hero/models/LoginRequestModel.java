package com.hero.hero.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestModel {
    private String usrName;
    private String password;
}
