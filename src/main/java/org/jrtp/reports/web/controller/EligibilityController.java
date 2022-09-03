package org.jrtp.reports.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jrtp.reports.service.EligibilityDTLSService;
import org.jrtp.reports.web.dto.request.EligibilitySearchRequest;
import org.jrtp.reports.web.dto.response.EligibilitySearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

@RestController
public class EligibilityController {
	
	@Autowired
	private EligibilityDTLSService service;
		
	@PostMapping("/reports")
	public ResponseEntity<List<EligibilitySearchResponse>> getListByQuery(@RequestBody EligibilitySearchRequest request) {
		return new ResponseEntity<List<EligibilitySearchResponse>> (service.getByQuery(request), HttpStatus.OK);
	}
	
	@GetMapping("/plan-names")
	public ResponseEntity<List<String>> getPlanNames() {
		return new ResponseEntity<List<String>> (service.getAllUniquePlanNames(), HttpStatus.OK);
	}
	
	@GetMapping("/plan-status")
	public ResponseEntity<List<String>> getPlanStatus() {
		return new ResponseEntity<List<String>> (service.getAllUniquePlanStatus(), HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void getXlsReport(HttpServletResponse response) throws Exception{
		service.exportXLS(response);
	}
	
	@GetMapping("/pdf")
	public void getPdfReport(HttpServletResponse response) {
		service.exportPDF(response);		
	}		
}