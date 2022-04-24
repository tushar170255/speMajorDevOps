package com.hero.hero.repo;

import com.hero.hero.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
     Admin findByUsrName(String name);
}
