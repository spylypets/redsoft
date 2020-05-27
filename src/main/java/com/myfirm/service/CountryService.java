package com.myfirm.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myfirm.model.Country;

@Service
public class CountryService {
	
	Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${countries.url}")
    private String url;
	
	public List<Country> getCountriesSortedByStandardRate() {
		
		return getCountryMap().values().stream().sorted(Comparator.comparing(Country::getStandardRate)).collect(Collectors.toList());
	}
	
	public Map<String, Country> getCountryMap() {
		
		try {
			return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Country>>() {}).getBody();
		} catch (Exception e) {
			logger.error("Error while retrieving countries: " + e.getMessage());
			return null;
		}
	}

}
