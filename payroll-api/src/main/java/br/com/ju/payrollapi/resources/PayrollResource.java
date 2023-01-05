package br.com.ju.payrollapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ju.payrollapi.domain.Payroll;
import br.com.ju.payrollapi.domain.User;
import br.com.ju.payrollapi.feignclients.UserFeign;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {
	
	private final UserFeign userFeign;
	
	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
		
		User user = userFeign.findById(workerId).getBody();
		
		return ResponseEntity.ok().body(
				new Payroll(
						user.getName(),
						payment.getDescription(), 
						user.getHourlyPrice(), 
						payment.getWorkedHours(),
						user.getHourlyPrice() * payment.getWorkedHours())
		);
	}

}
