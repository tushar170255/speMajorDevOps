package com.hero.hero.controller;

import com.hero.hero.models.Hero;
import com.hero.hero.models.LoginRequestModel;
import com.hero.hero.models.Needy;
import com.hero.hero.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/hero")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("{*}")


public class HeroController {
    @Autowired
    public HeroService heroService;

    @PostMapping("/")
    public Hero createHero(@RequestBody Hero hero) throws Exception
    {
        return this.heroService.createHero(hero);
    }
    @PostMapping ("/login")
    public Hero loginHero(@RequestBody  LoginRequestModel request) throws Exception
    {
        System.out.println("in needy login controller");
        Hero hero= this.heroService.loginHero(request.getUsrName(), request.getPassword());

        return hero;

    }
    @PutMapping("/{pinCode}")
    public ArrayList<Long> findHero(@PathVariable Long pinCode,@RequestBody Needy needy) throws Exception
    {
        return this.heroService.findHero(pinCode,needy);
    }
    @PutMapping("/accept/{needyid}")
   public Hero acceptNeedy(@PathVariable Long needyid ,@RequestBody Long heroid) throws Exception
    {
        return this.heroService.acceptNeedy(needyid,heroid);
    }

    @PutMapping ("/completed/{needyid}")
    public Boolean taskCompleted(@PathVariable Long needyid ,@RequestBody Long heroid)
    {
        return this.heroService.taskCompleted(needyid,heroid);
    }
    @PutMapping ("/feedback/{needyid}")
    public void feedback(@PathVariable Long needyid , @RequestBody String like)
    {
        System.out.println(like);
        this.heroService.feedback(needyid, like);

    }
    @GetMapping ("/catchupneedy/{usrName}")
    public HashSet<Needy> catchUpNeedy(@PathVariable String usrName)
    {
       return  this.heroService.catchUpNeedy(usrName);

    }
    @PutMapping("/heroeditprofile")
    public  Boolean editHeroProfile (@RequestBody Hero hero) throws IOException {
        return this.heroService.editHeroProfile(hero);
    }


}
