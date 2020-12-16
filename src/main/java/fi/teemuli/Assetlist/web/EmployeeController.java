package fi.teemuli.Assetlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.teemuli.Assetlist.domain.Employee;
import fi.teemuli.Assetlist.domain.EmployeeEnroll;
import fi.teemuli.Assetlist.domain.EmployeeRepository;

@Controller
public class EmployeeController {

//Inject CRUD functionality from repository-classes for Controller here
	@Autowired
	private EmployeeRepository erepository;
//End of CRUD injection	

//Employee manipulation
	
	//Add new EMPLOYEE
	//Part 1 -> direct to add page
	@GetMapping("/new")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'HR')")
	public String addEmployee(Model model) {
		model.addAttribute("employeeenroll", new EmployeeEnroll());
		return "addemployee";
	} 
	
	//Part 2 -> Save added data
	@PostMapping("/savee")
	public String saveE(@ModelAttribute("employeeenroll") EmployeeEnroll employeeEnroll, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			Employee newEmployee = new Employee();
			newEmployee.setFname(employeeEnroll.getFname());
			newEmployee.setLname(employeeEnroll.getLname());
			newEmployee.setEmail(employeeEnroll.getEmail());
			newEmployee.setPhone(employeeEnroll.getPhone());
			if (erepository.findByEmail(employeeEnroll.getEmail()) == null) {
				erepository.save(newEmployee);
			}
			else {
				bindingResult.rejectValue("email", "err.email", "Employee with this email already exists");
				return "addemployee";
			}
		
		}
		else {
			return "addemployee";
		}
		return "redirect:/assetlist";
	}
	
}
