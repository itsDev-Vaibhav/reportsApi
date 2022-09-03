package org.jrtp.reports.web.dto.request;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

@Data
public class EligibilitySearchRequest {
	
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
}
