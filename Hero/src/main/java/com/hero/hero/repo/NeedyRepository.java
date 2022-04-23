package com.hero.hero.repo;

import com.hero.hero.models.Needy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedyRepository extends JpaRepository<Needy,Long> {
    public Needy findByUsrName(String name);
    public void deleteById(Long id);
    public Needy findByid(Long id);
}


