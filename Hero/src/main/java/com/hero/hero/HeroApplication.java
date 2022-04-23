package com.hero.hero;

import com.hero.hero.services.NeedyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroApplication implements CommandLineRunner {
@Autowired
private NeedyService needyService;
	public static void main(String[] args) {

		SpringApplication.run(HeroApplication.class, args);
	}

	@Override
	public void run(String... args  ) throws Exception{
		System.out.println("starting the code");

	//	Needy needyAbhay=  Needy.builder().usrName("AbhayAravinda002").age(100).address("IIITB Bhaskara").firstName("ABHAY").lastName("ARAVINDA").sex("M").email("abhay@gmail.com").disable(true).disability("altruism").password("terror").phone("420").pinCode(560070).build();
		//Needy needy = this.needyService.createNeedy(needyAbhay);


		return ;
	}

}
