package com.hero.hero.controller;

import com.hero.hero.models.Hero;
import com.hero.hero.models.LoginRequestModel;
import com.hero.hero.models.Needy;
import com.hero.hero.models.feedbackNeedy;
import com.hero.hero.services.NeedyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashSet;

@RestController
@RequestMapping("/needy")
//@CrossOrigin("http://localhost:4200/")
@CrossOrigin("{*}")


public class NeedyController {
    @Autowired
    private NeedyService needyService;

    @PostMapping("/")
    public Needy createNeedy(@RequestBody Needy needy) throws Exception
    {
        return this.needyService.createNeedy(needy);
    }
    @GetMapping("/{userName}")
    public Needy getNeedyBYUserName (@PathVariable("userName") String usrName) throws Exception
    {
     return this.needyService.getNeedyByUserName(usrName);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long  id) throws Exception
    {
        this.needyService.deleteNeedyById(id);
    }
    @PostMapping("/login")
    public Needy loginNeedy(@RequestBody LoginRequestModel request) throws Exception
    {
        Needy needy = this.needyService.loginNeedy(request.getUsrName(), request.getPassword());
      
        return needy;

    }
    @PutMapping("/edit/{id}")
    public Needy editNeedy (@RequestBody Needy needy,@PathVariable long id) throws Exception
    {
        System.out.println("in needy edit contoroller");
        return this.needyService.editNeedy(needy,id);
    }

    @GetMapping("/component/{id}")
    public Long findComponent(@PathVariable Long id) throws Exception
    {
        return this.needyService.findComponent(id);
    }
    @GetMapping("/showhero/{id}")
    public Hero showHero(@PathVariable Long id) throws Exception{
        return this.needyService.showHero(id);
    }


    @PutMapping("/taskcompleted/{needyId}")
    public Boolean taskCompleted (@PathVariable Long  needyId,@RequestBody Long heroId)
    {
        return this.needyService.taskCompleted(needyId,heroId);

    }

    @PutMapping("/taskfinished/{needyId}")
     public Boolean taskFinished(@PathVariable Long needyId , @RequestBody feedbackNeedy  feedback)
    {

        return this.needyService.taskFinished(needyId,feedback.getHeroId(),feedback.getLikes());
    }

    @GetMapping("/catchupheroes/{usrName}")
    public HashSet<Hero> catchUpHeroes(@PathVariable String usrName) throws IOException {
        return this.needyService.catchUpHeroes(usrName);

    }



}
