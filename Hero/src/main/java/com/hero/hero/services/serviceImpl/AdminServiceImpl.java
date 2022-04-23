package com.hero.hero.services.serviceImpl;

import com.hero.hero.models.Admin;
import com.hero.hero.repo.AdminRepository;
import com.hero.hero.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
private AdminRepository adminRepository;
    @Override
    public Admin loginAdmin(String usrName, String password) throws Exception {
        Admin temp=this.adminRepository.findByUsrName(usrName);
        if(temp== null)
        {
            throw new Exception("invalid  credential!!");
        }
        else{
            if((temp.getPassword().equals(password)))
            {
                return temp;

            }
            else{
                throw new Exception("Invalid credentials");
            }
        }
    }
}
