package rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	@GetMapping(path="/", produces="application/json")
	public Employees getEmployees() {
		return dao.getAllEmployees();
	}
	@PostMapping(path="/",consumes="application/json", produces="application/json")
	public ResponseEntity<Object> addEmployee(
			/*@RequestHeader(name="X-COM-PERSIST",required=true) String headerPersist,
			@RequestHeader(name="X-COM-LOATION",required=false,defaultValue="ASIA") 
			String headerLocation,*/ @RequestBody Employee employee)
	{
		// Generate resource Id
		Integer id = dao.getAllEmployees().getEmployeeList().size()+1;
		employee.setId(id);
		
		//add resource
		dao.addEmployee(employee);
		
		//create resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(employee.getId())
						.toUri();
		
		//Send location in response
		return ResponseEntity.created(location).build();
	}
}
