package org.jrtp.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportApiApplication.class, args);
	}
	
	
////	to store the data in db.
//	@Bean
//	CommandLineRunner run(EligibilityDTLSRepo service) {
//		return args -> {
//			service.saveEligibilityDTLS(new EligibilityDTLS(1, "Zack Owen", 567891234l, "zack@123mail.com", 'M', "abvcd12232", "MEDICARE", "ACTIVE", LocalDate.of(2017, 1, 13), LocalDate.of(2020, 1, 12), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(2, "Peter Parker", 5389651234l, "peter@gmail.com", 'M', "cd122abv32", "SNAP", "PENDING", LocalDate.of(2014, 12, 31), LocalDate.of(2024, 12, 30), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(3, "John Doe", 124891234l, "john@yahoomail.com", 'M', "d122abvc32", "CCAP", "ACTIVE", LocalDate.of(2020, 1, 13), LocalDate.of(2022, 1, 12), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(4, "Charles Joe", 695891234l, "doe@ymail.com", 'M', "cd122abv32", "NJW", "ACTIVE", LocalDate.of(2019, 12, 31), LocalDate.of(2025, 8, 30), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(5, "David lahm", 789891234l, "lahm@gmail.com", 'M', "2232abvcd1", "MEDICARE", "PENDING", LocalDate.of(2020, 3, 1), LocalDate.of(2021, 4, 30), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(6, "Andrew foo", 147891234l, "andrew@123mail.com", 'M', "ab32vcd122", "MEDICARE", "ACTIVE", LocalDate.of(2008, 6, 13), LocalDate.of(2020, 9, 12), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(7, "Maria Jones", 639891234l, "marium@yahoomail.com", 'F', "abv232cd22", "NJW", "COMPLETED", LocalDate.of(2018, 1, 13), LocalDate.of(2020, 1, 12), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(8, "Catie Parker", 852891234l, "catie@rediffmail.com", 'F', "abvsd56232", "NJW", "ACTIVE", LocalDate.of(2022, 1, 13), LocalDate.of(2025, 4, 12), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(9, "Ashley", 741891234l, "ashley@gmail.com", 'F', "abwqs2232", "SNAP", "COMPLETED", LocalDate.of(2017, 1, 13), LocalDate.of(2020, 1, 12), null, null, null, null));
//			service.saveEligibilityDTLS(new EligibilityDTLS(10, "Delanie", 963891234l, "delanie@ymail.com", 'F', "reqcd13274", "MEDICARE", "ACTIVE", LocalDate.of(2017, 1, 13), LocalDate.of(2025, 1, 12), null, null, null, null));
//		};
//	}
	

}
