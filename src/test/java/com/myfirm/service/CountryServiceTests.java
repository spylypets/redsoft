package com.myfirm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.mifirm.model.Country;

public class CountryServiceTests {
	
	static Map<String, Country> testMap = new HashMap<>();
	
	static {
		testMap.put("CZ", new Country("Czech Republic", 21, 0, 0, 0, null));
		testMap.put("MT", new Country("Malta", 18, 0, 0, 0, null));
		testMap.put("SE", new Country("Sweden", 25, 0, 0, 0, null));
		testMap.put("SK", new Country("Slovakia", 20, 0, 0, 0, null));
	}
	
	@Mock
	CountryService countryService;
	
	@BeforeEach
	public void initMocks() {
	       MockitoAnnotations.initMocks(this);
	   }
	
	@Test
	void test_getCountriesSortedByStandardRate() {
		
		when(countryService.getCountryMap()).thenReturn(testMap);
		when(countryService.getCountriesSortedByStandardRate()).thenCallRealMethod();
		List<Country> countryList = countryService.getCountriesSortedByStandardRate();
		assertNotNull(countryList);
		assertEquals(4, countryList.size());
		assertEquals("Malta", countryList.get(0).getName());
		assertEquals("Sweden", countryList.get(3).getName());
	}

}
