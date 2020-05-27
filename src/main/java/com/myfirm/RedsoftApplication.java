package com.myfirm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.myfirm.model.Country;
import com.myfirm.service.CountryService;

@SpringBootApplication
public class RedsoftApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(RedsoftApplication.class);
	
	@Autowired
	CountryService countryService;

	public static void main(String[] args) {
		
		SpringApplication.run(RedsoftApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Country> sortedCountries = countryService.getCountriesSortedByStandardRate();
		
		logger.info("Two countries with the lowest standard VAT rate:");
		logger.info(sortedCountries.get(0).getName() + ": " + sortedCountries.get(0).getStandardRate());
		logger.info(sortedCountries.get(1).getName() + ": " + sortedCountries.get(1).getStandardRate());
		
		logger.info("Two countries with the highest standard VAT rate:");
		logger.info(sortedCountries.get(sortedCountries.size() - 1).getName() + ": " + sortedCountries.get(sortedCountries.size() - 1).getStandardRate());
		logger.info(sortedCountries.get(sortedCountries.size() - 2).getName() + ": " + sortedCountries.get(sortedCountries.size() - 2).getStandardRate());
		logger.info("OR:");
		logger.info(sortedCountries.get(sortedCountries.size() - 3).getName() + ": " + sortedCountries.get(sortedCountries.size() - 3).getStandardRate());
		
	}

}
