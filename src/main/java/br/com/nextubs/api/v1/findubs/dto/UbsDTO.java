package br.com.nextubs.api.v1.findubs.dto;

import br.com.nextubs.api.v1.findubs.model.Ubs;
import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(value = "Ubs", description = "Basic health unit")
public class UbsDTO {
	
	@Getter
	private Long id;
	
	@Getter
	private String name;
	
	@Getter
	private String address;
	
	@Getter
	private String city;
	
	@Getter
	private String phone;
	
	@Getter
	private GeocodeDTO geocode;
	
	@Getter
	private ScoresDTO scores;
	
	public void ubsToUbsDTO(Ubs ubs) {
		this.id = ubs.getId();
		this.name = ubs.getNomEstab();
		this.address = ubs.getDscEndereco();
		this.city = ubs.getDscCidade();
		this.phone = ubs.getDscTelefone();
		
		GeocodeDTO geocodeDTO = new GeocodeDTO();
		geocodeDTO.dataToGeocodeDTO(ubs.getVlrLatitude(), ubs.getVlrLongitude());
		this.geocode = geocodeDTO;
		
		ScoresDTO scoresDTO = new ScoresDTO();
		scoresDTO.dataToScoresDTO(ubs.getDscEstrutFisicAmbiencia(), ubs.getDscAdapDeficFisicIdosos(), ubs.getDscEquipamentos(), ubs.getDscMedicamentos());
		this.scores = scoresDTO;
	}

}
