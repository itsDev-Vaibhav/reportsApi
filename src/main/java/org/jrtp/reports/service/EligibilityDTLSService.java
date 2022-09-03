package org.jrtp.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jrtp.reports.web.dto.request.EligibilitySearchRequest;
import org.jrtp.reports.web.dto.response.EligibilitySearchResponse;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

public interface EligibilityDTLSService {
	
	public List<EligibilitySearchResponse>getByQuery(EligibilitySearchRequest request);
	public void exportXLS(HttpServletResponse response);
	public void exportPDF(HttpServletResponse response);
	public List<String>getAllUniquePlanNames();
	public List<String>getAllUniquePlanStatus();

}
