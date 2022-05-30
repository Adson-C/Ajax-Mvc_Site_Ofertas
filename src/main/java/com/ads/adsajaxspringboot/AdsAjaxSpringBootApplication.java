package com.ads.adsajaxspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ads.adsajaxspringboot.domain.SocialMetaTag;
import com.ads.adsajaxspringboot.service.SocialMetaTagService;

@SpringBootApplication
public class AdsAjaxSpringBootApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdsAjaxSpringBootApplication.class, args);
		
	}
	
	@Autowired
	SocialMetaTagService service;

	@Override
	public void run(String... args) throws Exception {
		
		SocialMetaTag og = service.getOpenGraphByUrl("https://www.pichau.com.br/monitor-gamer-mancer-valak-23-6-pol-va-curvo-fhd-1ms-180hz-freesync-e-g-sync-hdmi-dp-mcr-vlk24-bl01");
		System.out.println(og.toString());

		SocialMetaTag twitter = service.getTwitterCardByUrl("https://www.pichau.com.br/");
		System.out.println(twitter.toString());

		
	}

}
