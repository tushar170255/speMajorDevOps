package com.hero.hero.services;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;

@Service
public interface NeedyService {
    Needy createNeedy(Needy needy) throws Exception;
    Needy getNeedyByUserName(String name) throws Exception;
    void deleteNeedyById(Long id) throws Exception;
     Needy loginNeedy(String usrName,String password) throws Exception;
     Needy editNeedy(Needy needy ,Long id ) throws Exception;
     Long findComponent(Long id) throws Exception;
     Hero showHero(Long id)throws Exception;
//     Needy prepareNeedyResponse(Needy needy) throws Exception;
     Boolean taskCompleted (Long needId,Long heroId);
     Boolean taskFinished(Long needyId ,Long heroId, String likes);
     HashSet<Hero> catchUpHeroes (String usrName) throws IOException;


}

