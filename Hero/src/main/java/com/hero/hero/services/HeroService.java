package com.hero.hero.services;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public interface HeroService {
    Hero createHero( Hero hero ) throws Exception;
    Hero loginHero(String usrName ,String password) throws Exception;
    ArrayList<Long> findHero(Long pinCode, Needy needy) throws Exception;
    Hero acceptNeedy(Long needyid,Long heroid ) throws IOException;
//    Hero prepareResponse (Hero hero) ;
    Boolean taskCompleted(Long needyid,Long heroid);
    void feedback(Long needyid ,String like);
    HashSet<Needy> catchUpNeedy(String usrName);
    Boolean editHeroProfile (Hero hero) throws IOException;


}
