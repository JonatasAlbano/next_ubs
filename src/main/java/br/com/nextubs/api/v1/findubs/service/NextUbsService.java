package br.com.nextubs.api.v1.findubs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.nextubs.api.v1.findubs.dto.EntriesConfigResponseDTO;
import br.com.nextubs.api.v1.findubs.model.Ubs;
import br.com.nextubs.api.v1.findubs.repository.UbsRepository;

@Service
public class NextUbsService {
	
	@Autowired
	private UbsRepository repository;
	
	public EntriesConfigResponseDTO prepareEntriesConfig(List<Double> query, int page, int perPage) {
		double lat = query.get(0);
		double lon = query.get(1);
		
		// The pagination in database starts in 0
		page = page - 1;
		
		PageRequest pageable = PageRequest.of(page, perPage);
		List<Ubs> allUbs = repository.findAllUbsNextAPoint(lat, lon, pageable);
		
		EntriesConfigResponseDTO entriesConfigResponseDTO = new EntriesConfigResponseDTO();
		entriesConfigResponseDTO.dataToEntriesConfigResponseDTO(page, perPage, repository.findAll().size(), allUbs);
		
		return entriesConfigResponseDTO;
	}
	
}
