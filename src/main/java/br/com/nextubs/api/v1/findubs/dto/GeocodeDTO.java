package br.com.nextubs.api.v1.findubs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(value = "Geocode", description = "Coordinates of a Ubs")
public class GeocodeDTO {
	
	@Getter
	private Double lat;
	
	@Getter
	@JsonProperty("long")
	private Double lon;
	
	public void dataToGeocodeDTO(Double lat, Double lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
}
