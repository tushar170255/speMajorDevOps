package com.hero.hero.services;

import com.hero.hero.models.Hero;
import com.hero.hero.models.Needy;
import org.springframework.stereotype.Service;

@Service
public interface ResponseService {
    Needy needyResponse(Needy needy);
    Hero heroResponse (Hero hero);

}
