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
		
		SocialMetaTag tag = service.getSocialMetaTagByUrl("https://www.boticario.com.br/");
		System.out.println(tag.toString());


		
	}

}
