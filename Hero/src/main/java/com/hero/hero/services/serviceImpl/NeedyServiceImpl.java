package com.hero.hero.services.serviceImpl;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import com.hero.hero.repo.HeroRepository;
import com.hero.hero.repo.NeedyRepository;
import com.hero.hero.services.NeedyService;
import com.hero.hero.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class NeedyServiceImpl implements NeedyService {
    @Autowired
    private NeedyRepository needy_repository;

    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private ResponseService responseService;

    public String Image(String fileLocation) throws IOException {
        String file_content = Files.readString(Path.of(fileLocation));
        return file_content;
    }
    public String createFile(String usrName, String image) throws IOException {

          String fileLocation = new File("src//main//resources//static//"+usrName).getAbsolutePath();
          Path textFilePath = Paths.get(fileLocation);
          Files.createFile(textFilePath);
          Path fileName = Path.of(
                  fileLocation);

          // Writing into the file
          Files.writeString(fileName, image);
          return fileLocation ;
    }
    public String editFile(String usrName ,String image) throws IOException {

        String fileLocation = new File("src//main//resources//static//"+usrName).getAbsolutePath();
        Path textFilePath = Paths.get(fileLocation);
        PrintWriter writer = new PrintWriter(fileLocation);
        writer.print("");
        writer.close();
        Files.writeString(Path.of(fileLocation), image);

        return fileLocation;
    }
    @Override

    public Needy createNeedy(Needy needy) throws Exception
    {
        Needy temp;
      Needy local=  this.needy_repository.findByUsrName(needy.getUsrName());
      if(local!=null)
      {
          System.out.println("user is already there with same username ");
          throw new Exception("user already present !!!");
      }
      else{
//         String fileLocation= createFile(needy.getUsrName(),needy.getImage());
//          String img=needy.getImage();
//          String fileLocation = new File("src//main//resources//static//"+needy.getUsrName()).getAbsolutePath();
//          Path textFilePath = Paths.get(fileLocation);
//          Files.createFile(textFilePath);
//          Path fileName = Path.of(
//                  fileLocation);
//
//          // Writing into the file
//          Files.writeString(fileName, img);
          local=needy;
//         needy.setImage(fileLocation);
        this.needy_repository.save(needy);
      }
        return responseService.needyResponse(local);
      }
    @Override
    public Needy getNeedyByUserName(String userName) throws Exception
    {
        Needy local=this.needy_repository.findByUsrName(userName);
        if(local!=null)
        {
//            String x=local.getImage();
//            local.setImage(Image(x));
            return  responseService.needyResponse(local);
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
//        String fileLocation = editFile(needy.getUsrName(),needy.getImage());

        t.setImage(needy.getImage());
        t.setUsrName(needy.getUsrName());
        t.setDisable(needy.isDisable());
         needy_repository.save(t);
         return  responseService.needyResponse(t);



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
//                temp.setImage(Image(temp.getImage()));
                return  responseService.needyResponse(temp);

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

                 Hero hero =tmp.getHeroPending();
//         hero.setImage(Image(hero.getImage()));
//         hero.setAadhaarImage(Image(hero.getAadhaarImage()));
//         hero.setOtherIdentityImage(Image(hero.getOtherIdentityImage()));
        return responseService.heroResponse(hero);
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
      needy.setHeroCompletedId(heroId);
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
        List<Hero> Heroes=needy.getHeroes();
        Heroes.add(hero);
        needy.setHeroes(Heroes);
        List<Needy>Needs=hero.getNeeds();
        Needs.add(needy);
        hero.setNeeds( Needs);


        needy_repository.save(needy);
        heroRepository.save(hero);

return true;





    }
    public HashSet <Hero> catchUpHeroes (String usrName) throws IOException {
        Needy needy=needy_repository.findByUsrName(usrName);
        if(needy!=null)
        {
            List<Hero> x=needy.getHeroes();
            HashSet<Hero> y = new HashSet<>();
            for (Hero hero:x)
            {
//                hero.setImage(Image(hero.getImage()));
//                hero.setAadhaarImage(Image(hero.getAadhaarImage()));
//                hero.setOtherIdentityImage(Image(hero.getOtherIdentityImage()));
                y.add(responseService.heroResponse(hero));


            }
            return  y;
        }
        else{
            return null;
        }

    }

}

