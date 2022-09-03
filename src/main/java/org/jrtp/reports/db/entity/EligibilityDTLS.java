package org.jrtp.reports.db.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ELIGIBILITY_DETAILS")
public class EligibilityDTLS {
	
	@Id
	private Integer id;
	private String name;
	private Long mobileNumber;
	private String email;
	private Character gender;
	private String ssn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private LocalDate createdOn;
	private String createdBy;
	private LocalDate updatedOn;
	private String updatedBy;
	
}