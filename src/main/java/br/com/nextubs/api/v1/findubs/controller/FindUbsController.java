package br.com.nextubs.api.v1.findubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nextubs.api.v1.findubs.dto.EntriesConfigResponseDTO;
import br.com.nextubs.api.v1.findubs.service.NextUbsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api("Find UBS API")
@RestController
@AllArgsConstructor
@RequestMapping(value="/api/v1")
public class FindUbsController {
	
	@Autowired
	private NextUbsService nextUbsService;
	
	@ApiOperation(value="Return ubs near a determined place")
	@GetMapping("/find_ubs")
	public EntriesConfigResponseDTO findubs(@RequestParam List<Double> query, @RequestParam int page, @RequestParam int per_page) {
		return nextUbsService.prepareEntriesConfig(query, page, per_page);
	}

}
