package fi.teemuli.Assetlist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.teemuli.Assetlist.domain.Asset;
import fi.teemuli.Assetlist.domain.AssetRepository;
import fi.teemuli.Assetlist.domain.CategoryRepository;
import fi.teemuli.Assetlist.domain.EmployeeRepository;

@Controller
public class AssetController {
	
//Inject CRUD functionality from repository-classes for Controller here
	@Autowired
	private AssetRepository arepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private EmployeeRepository erepository;
//End of CRUD injection	

//Direct traffic to endpoints
	
	//Login
	@GetMapping("/login")
	public String login() {
		return "login";
	}
		
	//To direct user to desired start page from default address
	@GetMapping("/")
	public String redirect() {
		return "redirect:assetlist";
	}
	
	//Listing assets
	@GetMapping("assetlist")
 	public String assetList(Model model) {
		model.addAttribute("assets", arepository.findAll());
		return "assetlist";
	}
	
	//REST listing (to test REST is working for now)
	@GetMapping("assets")
	public @ResponseBody List<Asset> assetListRest() {
		return (List<Asset>) arepository.findAll();
	}


//ASSET manipulation
	
	//Delete functionality
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteAsset(@PathVariable("id") Long assetID, Model model) {
		arepository.deleteById(assetID);
		return "redirect:../assetlist";
	}
	
	//Add new ASSET
	//Part 1 -> direct to add page
	@GetMapping("/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addAsset(Model model) {
		model.addAttribute("asset", new Asset());
		model.addAttribute("categories", crepository.findAll());
		model.addAttribute("employees", erepository.findAll());
		return "addasset";
	}
	//Part 2 -> Save added data
	@PostMapping("/save")
	public String save(Asset asset) {
		arepository.save(asset);
		return "redirect:assetlist";
	}
	
	//Edit function
	@GetMapping("/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editAsset(@PathVariable("id") Long assetID, Model model) {
		model.addAttribute("asset", arepository.findById(assetID));
		model.addAttribute("categories", crepository.findAll());
		model.addAttribute("employees", erepository.findAll());
		return "editasset";
	}

//EMPLOYEE manipulation
/*	
	//Add new EMPLOYEE
	//Part 1 -> direct to add page
	@GetMapping("/new")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addemployee";
	}
	//Part 2 -> Save added data
	@PostMapping("/savee")
	public String saveE(Employee employee) {
		erepository.save(employee);
		return "redirect:assetlist";
	}
	
	/*
	@PostMapping("/savee")
	public String saveE(@ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			
			Employee newEmployee = new Employee();
			newEmployee.setFname(employee.getFname());
			newEmployee.setLname(employee.getLname());
			newEmployee.setEmail(employee.getEmail());
			newEmployee.setPhone(employee.getPhone());
			if (erepository.findByEmail(employee.getEmail()) == null) {
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
		return "redirect:assetlist";
	} */
}
