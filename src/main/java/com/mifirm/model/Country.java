package com.mifirm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	
	@JsonProperty("country")
	private String name;
	
	@JsonProperty("standard_rate")
	private int standardRate;
	
	@JsonProperty("reduced_rate")
	private int reducedRate;
	
	@JsonProperty("reduced_rate_alt")
	private int reducedRateAlt;
	
	@JsonProperty("parking_rate")
	private int parkingRate;
	
	@JsonProperty("iso_duplicate")
	private String isoDuplicate;

}
