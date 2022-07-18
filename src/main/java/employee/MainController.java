package employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller 
@RequestMapping(path = "/api") 

public class MainController {
	@Autowired 
	private EmployeeRepository employeeRepository;

	@PostMapping(path = "/add") 
	public @ResponseBody String addNewEmployee(@RequestParam String name, @RequestParam String email) {


		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmail(email);
		employeeRepository.save(emp);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {

		return employeeRepository.findAll();

	}
	@GetMapping(path="/allById")
	public @ResponseBody Iterable<Employee> getAllIds(){
		return employeeRepository.findAll();
	}
  
	@GetMapping(path ="/findById/{id}")
	public @ResponseBody Employee findEmployeeById(@PathVariable("id") Integer id){
		return  employeeRepository.findById(id).get();
		  
		                
	} 
	  @GetMapping(path="/updateById/{id}")
	            public @ResponseBody String updateEmployeeById(@PathVariable("id") Integer id){
		         Optional<Employee> emp = employeeRepository.findById(id);
		          Employee modEmp = emp.get();
		                   modEmp.setEmail("newEmail@com");
		                   modEmp.setName("John Fink");
		                   employeeRepository.save(modEmp);
		               return "updated";
	        
	            	
	            }
	
}
