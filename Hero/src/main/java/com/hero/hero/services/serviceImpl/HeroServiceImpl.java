package com.hero.hero.services.serviceImpl;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import com.hero.hero.repo.HeroRepository;
import com.hero.hero.repo.NeedyRepository;
import com.hero.hero.services.HeroService;
import com.hero.hero.services.NeedyService;
import com.hero.hero.services.ResponseService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private  HeroRepository heroRepository;
    @Autowired
    private NeedyRepository needyRepository;
    @Autowired
    private NeedyService needyService;
    @Autowired
    private  ResponseService responseService;
//    public HeroServiceImpl(HeroRepository heroRepository, NeedyRepository needyRepository,NeedyService needyService) {
//        this.heroRepository = heroRepository;
//        this.needyRepository = needyRepository;
//        this.needyService= needyService;
//
//    }

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
        return responseService.heroResponse(local);

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
                return responseService.heroResponse(temp);

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




      return responseService.heroResponse(hero2);

    }

    @Override
    public Boolean taskCompleted (Long needyid, Long heroid)
    {
        Needy needy=needyRepository.findByid(needyid);
        needy.setHeroPending(null);
        needy.setHeroCompletedId(heroid);
        Hero hero=heroRepository.findByid(heroid);
        hero.setTask(hero.getTask()-1);


        List<Hero> heroes= (needy.getHeroes());
        heroes.add(hero);

        needy.setHeroes(heroes);
        List<Needy> needies=hero.getNeeds();
        needies.add(needy);

        hero.setNeeds(needies);

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
   @SneakyThrows
   @Override
    public HashSet<Needy> catchUpNeedy(String usrName)
   {
       Hero hero = heroRepository.findByUsrName(usrName);

       if(hero!=null)
       {
           List<Needy> temp=hero.getNeeds();
           HashSet<Needy> ans=new HashSet<Needy>();
           for ( Needy x:temp) {

               ans.add(responseService.needyResponse(x));
           }
           return ans;
       }
       return null;
   }
}
