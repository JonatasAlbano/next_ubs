package br.com.nextubs.api.v1.findubs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(value = "Scores", description = "Ubs structure assessments")
public class ScoresDTO {
	
	@Getter
	private String size;
	
	@Getter
	@JsonProperty("adaptation_for_seniors")
	private String adaptationForSeniors;
	
	@Getter
	@JsonProperty("medical_equipment")
	private String medicalEquipment;
	
	@Getter
	private String medicine;

	public void dataToScoresDTO(String size, String adaptationForSeniors, String medicalEquipment, String medicine) {
		this.size = size;
		this.adaptationForSeniors = adaptationForSeniors;
		this.medicalEquipment = medicalEquipment;
		this.medicine = medicine;
	}
	
	
}
