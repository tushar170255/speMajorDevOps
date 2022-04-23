package com.hero.hero.repo;

import com.hero.hero.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Long> {
     Hero findByUsrName(String name);
     Hero findTop1ByServicePincodeOrderByTaskAsc(Long pin);
     Hero findByid(Long id);
}
