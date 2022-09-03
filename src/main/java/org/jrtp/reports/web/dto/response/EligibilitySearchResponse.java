package org.jrtp.reports.web.dto.response;

import lombok.Data;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

@Data
public class EligibilitySearchResponse {

	private String name;
	private Long mobileNumber;
	private String email;
	private Character gender;
	private String ssn;
}
