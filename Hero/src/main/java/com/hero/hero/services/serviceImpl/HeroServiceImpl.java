package com.hero.hero.services.serviceImpl;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import com.hero.hero.repo.HeroRepository;
import com.hero.hero.repo.NeedyRepository;
import com.hero.hero.services.HeroService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final NeedyRepository needyRepository;
    private Object SortedSet;

    public HeroServiceImpl(HeroRepository heroRepository, NeedyRepository needyRepository) {
        this.heroRepository = heroRepository;
        this.needyRepository = needyRepository;
    }

    @Override
    public Hero createHero( Hero hero) throws Exception {
        Hero local=  this.heroRepository.findByUsrName(hero.getUsrName());
        if(local!=null)
        {
            System.out.println("user is already there with same username ");
            throw new Exception("user already present !!!");
        }
        else{
            local= this.heroRepository.save(hero);
        }
        return prepareResponse(local);

    }

    @Override
    public Hero loginHero(String usrName, String password) throws Exception {
        Hero temp= this.heroRepository.findByUsrName(usrName);
        if(temp ==null)
        {
            throw new Exception("invalid  credential!!");

        }
        else {
            if((temp.getPassword().equals(password)))
            {
                System.out.println(temp.getId());
                List<Needy> heroes = temp.getNeeds();
                heroes.forEach(needy -> temp.setNeeds(null));
                return prepareResponse(temp);

            }
            else{
                throw new Exception("Invalid credentials");
            }
        }
    }

    @Override
    public ArrayList<Long> findHero(Long pinCode,Needy needy) throws Exception {
        Hero temp=heroRepository.findTop1ByServicePincodeOrderByTaskAsc(pinCode);

  ArrayList<Long> res=new ArrayList<>();
//     int w=0;
//
//     for (Hero x : temp) {
//             System.out.println(x.getId());
//             res.add(x.getId());
////            w++;
////             if(w>=3)
////             {
////                 break;
////             }
////
//         }
//  System.out.println(res);
       needy.setHeroRequest(temp);
        needyRepository.save(needy);





return res;
    }

    @Override
    public Hero acceptNeedy(Long needyid,Long heroid)
    {
      Needy tmp=needyRepository.findByid(needyid);
      Hero hero2 = heroRepository.findByid(heroid);
      hero2.setTask(hero2.getTask()+1);
      tmp.setHeroRequest(null);
      tmp.setHeroPending(hero2);
      needyRepository.save(tmp);




      return prepareResponse(hero2);

    }
    @Override
    public Hero prepareResponse(Hero hero2)
    {if(hero2==null)
    {
        return null;
    }

        List<Needy> heroes = hero2.getNeeds();
        heroes.forEach(needy -> needy.setHeroes(null));
        hero2.setNeeds(heroes);
        heroes=hero2.getNeedyAccept();
        heroes.forEach(needy -> needy.setHeroRequest(null));
        hero2.setNeedyAccept(heroes);
        heroes=hero2.getNeedyPending();
        heroes.forEach(needy -> needy.setHeroPending(null));
        hero2.setNeedyPending(heroes);

        return hero2;
    }
    @Override
    public Boolean taskCompleted (Long needyid, Long heroid)
    {
        Needy needy=needyRepository.findByid(needyid);
        needy.setHeroPending(null);
        Hero hero=heroRepository.findByid(heroid);
        hero.setTask(hero.getTask()-1);


        List<Hero> heroes= (needy.getHeroes());
        heroes.add(hero);
        ArrayList x = (ArrayList) heroes;
        needy.setHeroes(x);
        List<Needy> needies=hero.getNeeds();
        needies.add(needy);
        x = (ArrayList)  needies;
        hero.setNeeds(x);

        needyRepository.save(needy);
        heroRepository.save(hero);


        return true;

    }
    @Override
    public void feedback(Long id, String like)
    {
        Needy needy=needyRepository.findByid(id);
        if(like=="1")
        {
            needy.setLikes(needy.getLikes()+1);
        }
        else{
            needy.setDislikes(needy.getDislikes()+1);
        }
        needyRepository.save(needy);

        return ;
    }

}
