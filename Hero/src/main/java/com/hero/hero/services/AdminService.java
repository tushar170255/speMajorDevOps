package com.hero.hero.services;

import com.hero.hero.models.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

     Admin loginAdmin(String usrName , String password) throws Exception;
}
