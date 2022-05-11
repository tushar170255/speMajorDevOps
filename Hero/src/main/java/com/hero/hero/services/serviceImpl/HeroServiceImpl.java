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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public String Image(String fileLocation) throws IOException {
    String file_content = Files.readString(Path.of(fileLocation));
    return file_content;
}


    public String createFile(String usrName, String image) throws IOException {

        String fileLocation = new File("src//main//resources//static//hero//"+usrName).getAbsolutePath();
        Path textFilePath = Paths.get(fileLocation);
        Files.createFile(textFilePath);
        Path fileName = Path.of(
                fileLocation);

        // Writing into the file
        Files.writeString(fileName, image);
        return fileLocation ;
    }
    public String editFile(String usrName ,String image) throws IOException {

        String fileLocation = new File("src//main//resources//static//hero"+usrName).getAbsolutePath();
        Path textFilePath = Paths.get(fileLocation);
        PrintWriter writer = new PrintWriter(fileLocation);
        writer.print("");
        writer.close();
        Files.writeString(Path.of(fileLocation), image);

        return fileLocation;
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
//            String fileLocation =createFile(hero.getUsrName(),hero.getImage());
//            hero.setImage(fileLocation);
//            fileLocation =createFile(hero.getUsrName()+"aadhar" ,hero.getAadhaarImage());
//            hero.setAadhaarImage(fileLocation);
//
//            fileLocation =createFile(hero.getUsrName()+"other" ,hero.getOtherIdentityImage());
//            hero.setOtherIdentityImage(fileLocation);



             this.heroRepository.save(hero);
        }
        hero=heroRepository.findByUsrName(hero.getUsrName());
//        hero.setImage(Image(hero.getImage()));
//        hero.setAadhaarImage(Image(hero.getAadhaarImage()));
//        hero.setOtherIdentityImage(Image(hero.getOtherIdentityImage()));
        return responseService.heroResponse(hero);

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
//                temp.setImage(Image(temp.getImage()));
//                temp.setAadhaarImage(Image(temp.getAadhaarImage()));
//                temp.setOtherIdentityImage(Image(temp.getOtherIdentityImage()));

                List<Needy> heroes = temp.getNeeds();
//                for (Needy needy : heroes) {
//                    needy.setImage(Image(needy.getImage()));
//                }
//                temp.setNeeds(heroes);
//                 heroes = temp.getNeedyAccept();
//                for (Needy needy : heroes) {
//                    needy.setImage(Image(needy.getImage()));
//                }
//                temp.setNeedyAccept(heroes);
//                heroes=temp.getNeedyPending();
//                for (Needy needy : heroes) {
//                    needy.setImage(Image(needy.getImage()));
//                }
//                temp.setNeedyPending(heroes);
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
//       String fileLocation =editFile(needy.getUsrName(),needy.getImage());
//       needy.setImage(fileLocation);
       
        needyRepository.save(needy);





return res;
    }

    @Override
    public Hero acceptNeedy(Long needyid,Long heroid) throws IOException {
      Needy tmp=needyRepository.findByid(needyid);
      Hero hero2 = heroRepository.findByid(heroid);
      hero2.setTask(hero2.getTask()+1);
      tmp.setHeroRequest(null);
      tmp.setHeroPending(hero2);
      needyRepository.save(tmp);


//        hero2.setImage(Image(hero2.getImage()));
//        hero2.setAadhaarImage(Image(hero2.getAadhaarImage()));
//        hero2.setOtherIdentityImage(Image(hero2.getOtherIdentityImage()));

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
//               x.setImage(Image(x.getImage()));
               ans.add(responseService.needyResponse(x));
           }
           System.out.println(ans);
           return ans;
       }
       else
       return null;
   }
   @Override
    public Boolean editHeroProfile (Hero hero) throws IOException {
//       String fileLocation=editFile(hero.getUsrName(),hero.getImage());
//       fileLocation =editFile(hero.getUsrName()+"aadhar",hero.getImage());
//       fileLocation =editFile(hero.getUsrName()+"other",hero.getImage());

       Hero t=heroRepository.findByUsrName(hero.getUsrName());
       t.setAddress(hero.getAddress());
       t.setAge(hero.getAge());
       t.setPassword(hero.getPassword());
       t.setBirthday(hero.getBirthday());
       t.setFirstName(hero.getFirstName());
       t.setEmail(hero.getEmail());
       t.setSex(hero.getSex());
       t.setLastName(hero.getLastName());
       t.setPhone(hero.getPhone());
       t.setPincode(hero.getPincode());
       t.setServicePincode(hero.getServicePincode());
//        String fileLocation = editFile(needy.getUsrName(),needy.getImage());

       t.setImage(hero.getImage());
       t.setUsrName(hero.getUsrName());
       t.setEnabled(hero.isEnabled());
       heroRepository.save(t);

       return true;
   }
}
