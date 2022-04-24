package com.hero.hero.services.serviceImpl;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import com.hero.hero.repo.HeroRepository;
import com.hero.hero.repo.NeedyRepository;
import com.hero.hero.services.HeroService;
import com.hero.hero.services.NeedyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NeedyServiceImpl implements NeedyService {
    @Autowired
    private NeedyRepository needy_repository;
    @Autowired
    private HeroService heroService;
    @Autowired
    private HeroRepository heroRepository;
    @Override
    public Needy createNeedy(Needy needy) throws Exception
    {
      Needy local=  this.needy_repository.findByUsrName(needy.getUsrName());
      if(local!=null)
      {
          System.out.println("user is already there with same username ");
          throw new Exception("user already present !!!");
      }
      else{
        local= this.needy_repository.save(needy);
      }
        return prepareNeedyResponse(local);
      }
    @Override
    public Needy getNeedyByUserName(String userName) throws Exception
    {
        Needy local=this.needy_repository.findByUsrName(userName);
        if(local!=null)
        {
            return prepareNeedyResponse(local);
        }
        else{
            System.out.println("username does not exist");
            throw new Exception("user not present");
        }

    }

    @Override
    public Needy editNeedy(Needy needy, Long id) throws Exception {
       Needy t=this.needy_repository.findByid(id);
        if(t == null)
        {
            throw new Exception("invalid crendential");

        }
//        Needy t= temp;

        t.setAddress(needy.getAddress());
        t.setAge(needy.getAge());
        t.setPassword(needy.getPassword());
        t.setBirthday(needy.getBirthday());
        t.setDisability(needy.getDisability());
        t.setFirstName(needy.getFirstName());
        t.setEmail(needy.getEmail());
        t.setSex(needy.getSex());
        t.setLastName(needy.getLastName());
        t.setPhone(needy.getPhone());
        t.setPincode(needy.getPincode());
        t.setImage(needy.getImage());
        t.setUsrName(needy.getUsrName());
        t.setDisable(needy.isDisable());
        return  needy_repository.save(t);



    }

    @Override
    public Needy loginNeedy(String usrName, String password) throws Exception {
        Needy temp= this.needy_repository.findByUsrName(usrName);

        if(temp== null)
        {
            throw new Exception("Invalid credential");
        }
        else{
            if(temp.getPassword().equals(password))
            {
                return prepareNeedyResponse(temp);

            }
            else{
                throw new Exception("Invalid credentials");
            }
        }


    }

    @Override
    public void deleteNeedyById(Long id) throws Exception{

        Optional<Needy> local =this.needy_repository.findById(id);
        if(local== null)
        {  throw new Exception("user not present");

        }
        else{
        this.needy_repository.deleteById(id);
        }
    }

    @Override
    public Long findComponent(Long id) throws Exception{

        Needy tmp=needy_repository.findByid(id);
        if(tmp.getHeroRequest()==null&& tmp.getHeroPending()==null)
        {
            return Long.valueOf(1);
        }

        else if(tmp.getHeroRequest()!=null && tmp.getHeroPending()==null)
        {
            return Long.valueOf(2);
        }
        else if(tmp.getHeroRequest()==null && tmp.getHeroPending()!=null)
        {
            return Long.valueOf(3);
        }
        return Long.valueOf(100);
    }
    @Override
    public Hero showHero(Long id) throws Exception{

        Needy tmp=needy_repository.findByid(id);

        return heroService.prepareResponse(tmp.getHeroPending());
    }
    @Override

    public Needy prepareNeedyResponse(Needy needy)
    {
        if(needy==null) return null;
        needy.getHeroes().forEach(x -> needy.setHeroes(null));

        needy.setHeroRequest(heroService.prepareResponse(needy.getHeroRequest()));
        needy.setHeroPending(heroService.prepareResponse(needy.getHeroPending()));

        return needy;
    }



    @Override
    public Boolean taskCompleted(Long needyId, Long heroId)
    {
        Hero hero=heroRepository.findByid(heroId);
        Needy needy =needy_repository.findByid(needyId);
      if(needy == null || hero == null)
      {
          return false;
      }
       needy.setHeroPending(null);
        List<Hero> x= needy.getHeroes();
        x.add(hero);
        needy.setHeroes(x);
        List<Needy> y= hero.getNeeds();
        y.add(needy);
        hero.setNeeds(y);




        needy.setHeroCompletedId(hero.getId());


needy_repository.save(needy);
heroRepository.save(hero);

        return true;



    }

    @Override
    public Boolean taskFinished(Long needyId, Long heroId, String likes)
    {
        Needy needy=needy_repository.findByid(needyId);
        Hero hero =heroRepository.findByid(heroId);
       if(hero==null || needy==null)
       {
           return false;
       }
        needy.setHeroCompletedId((long)  (-1));
        if(likes =="1")
        {
            hero.setLikes(hero.getLikes()+1);
        }
        else{
            hero.setDislikes(hero.getDislikes()+1);
        }

        needy_repository.save(needy);
        heroRepository.save(hero);

return true;





    }

}

