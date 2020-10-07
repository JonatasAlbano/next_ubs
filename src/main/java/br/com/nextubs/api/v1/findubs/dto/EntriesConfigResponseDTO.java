package br.com.nextubs.api.v1.findubs.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.nextubs.api.v1.findubs.model.Ubs;
import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(value = "EntriesConfigResponse", description = "Response from ubs api")
@JsonPropertyOrder({"current_page", "per_page", "total_entries", "entries"})
public class EntriesConfigResponseDTO {
	
	@Getter
	@JsonProperty("current_page")
	private int currentPage;
	
	@Getter
	@JsonProperty("per_page")
	private int perPage;
	
	@Getter
	@JsonProperty("total_entries")
	private int totalEntries;
	
	@Getter
	private List<UbsDTO> entries;
	
	public void dataToEntriesConfigResponseDTO(int currentPage, int perPage, int totalEntries, List<Ubs> listUbs) {
		this.currentPage = currentPage;
		this.perPage = perPage;
		this.totalEntries = totalEntries;
		
		entries = new ArrayList<>();
		
		for(Ubs ubs: listUbs) {
			UbsDTO ubsDTO = new UbsDTO();
			ubsDTO.ubsToUbsDTO(ubs);
			entries.add(ubsDTO);
		}
	}
	

}
