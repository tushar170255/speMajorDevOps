package com.hero.hero.services.serviceImpl;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import com.hero.hero.services.ResponseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResponseServiceImpl implements ResponseService {
    @Override
    public Needy needyResponse(Needy needy)
    {
        if(needy==null) return null;
        if(needy.getHeroes()!=null) needy.getHeroes().forEach(x -> needy.setHeroes(null));

        needy.setHeroRequest(heroResponse(needy.getHeroRequest()));
        needy.setHeroPending(heroResponse(needy.getHeroPending()));

        return needy;
    }
    @Override
    public Hero heroResponse(Hero hero2)
    {if(hero2==null)
    {
        return null;
    }

        List<Needy> heroes = hero2.getNeeds();
        if(heroes!=null && heroes.size()>0)
            heroes.forEach(needy -> needy.setHeroes(null));

        hero2.setNeeds(heroes);

        List<Needy>  heroes1;

        heroes1=hero2.getNeedyAccept();
        if(heroes1!=null && heroes1.size()>0)
            heroes1.forEach(needy -> needy.setHeroRequest(null));

        hero2.setNeedyAccept(heroes1);
        heroes1=hero2.getNeedyPending();
        if(heroes1.size()>0)
            heroes1.forEach(needy -> needy.setHeroPending(null));

        hero2.setNeedyPending(heroes1);

        return hero2;
    }

}
