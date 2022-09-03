package org.jrtp.reports.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jrtp.reports.app.utils.AppConstants;
import org.jrtp.reports.app.utils.ExcelGenerator;
import org.jrtp.reports.app.utils.PdfGenerator;
import org.jrtp.reports.db.entity.EligibilityDTLS;
import org.jrtp.reports.db.repository.EligibilityDTLSRepo;
import org.jrtp.reports.service.EligibilityDTLSService;
import org.jrtp.reports.web.dto.request.EligibilitySearchRequest;
import org.jrtp.reports.web.dto.response.EligibilitySearchResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

@Service
public class EligibilityDTLSServiceImpl implements EligibilityDTLSService{
	
	@Autowired
	private EligibilityDTLSRepo repo;
	
	private List<EligibilitySearchResponse> responseList;
	

	/**
	 * @param findAll
	 * @return
	 */
	private List<EligibilitySearchResponse> chngeToResponseList(List<EligibilityDTLS> detailList) {
		if (!(detailList.isEmpty())) {
			responseList = new ArrayList<>();
			detailList.forEach((EligibilityDTLS e) -> {
				EligibilitySearchResponse response = new EligibilitySearchResponse();
				BeanUtils.copyProperties(e, response);
				this.responseList.add(response);
			});
			return responseList;
		}
		return null;
	}


	@Override
	public List<EligibilitySearchResponse> getByQuery(EligibilitySearchRequest request) {
		EligibilityDTLS entity = new EligibilityDTLS();
		
		if(request.getPlanName() != null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
		}
		
		if(request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if(request.getPlanStartDate() != null) {
			entity.setPlanStartDate(request.getPlanStartDate());
		}
		
		if(request.getPlanEndDate() != null) {
			entity.setPlanEndDate(request.getPlanEndDate());
		}
		
		Example<EligibilityDTLS> example = Example.of(entity);
		return chngeToResponseList(repo.findAll(example));
	}

	@Override
	public void exportXLS(HttpServletResponse response) {
		this.responseList = chngeToResponseList(repo.findAll());
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;fileName=" + AppConstants.REPORT_NAME + LocalDateTime.now() + AppConstants.XLS_EXTENSION;
		response.setHeader(headerKey, headerValue);
		new ExcelGenerator(this.responseList).generateExcel(response);
	}

	@Override
	public void exportPDF(HttpServletResponse response) {
		this.responseList = chngeToResponseList(repo.findAll());
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;fileName=" + AppConstants.REPORT_NAME + LocalDateTime.now() + AppConstants.PDF_EXTENSION;
		response.setHeader(headerKey, headerValue);
		new PdfGenerator(this.responseList).createPDF(response);
	}

	@Override
	public List<String> getAllUniquePlanNames() {
		List<String> uniquePlanNames = repo.getUniquePlanNames();
		if(uniquePlanNames.isEmpty()) {
			return null;
		}
		return uniquePlanNames;
	}

	@Override
	public List<String> getAllUniquePlanStatus() {
		List<String> uniquePlanStatus = repo.getUniquePlanStatus();
		if(uniquePlanStatus.isEmpty()) {
			return null;
		}
		return uniquePlanStatus;
	}
}
