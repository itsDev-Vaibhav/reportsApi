package org.jrtp.reports.db.repository;

import java.util.List;

import org.jrtp.reports.db.entity.EligibilityDTLS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

public interface EligibilityDTLSRepo extends JpaRepository<EligibilityDTLS, Integer> {
	
	@Query(value = "SELECT DISTINCT e.planName FROM EligibilityDTLS e", nativeQuery = false)
	List<String> getUniquePlanNames();
	
	
	@Query(value = "SELECT DISTINCT e.planStatus FROM EligibilityDTLS e", nativeQuery = false)
	List<String> getUniquePlanStatus();
	
	
	
}
