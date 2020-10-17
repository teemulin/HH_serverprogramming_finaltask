package fi.teemuli.Assetlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import fi.teemuli.Assetlist.domain.AssetRepository;

@Controller
public class AssetController {
	
	@Autowired
	private AssetRepository arepository;
	
	@GetMapping("/")		//To direct user to right page for now
	public String redirect() {
		return "redirect:assetlist";
	}
	
	//Listing assets
	@GetMapping("assetlist")
 	public String assetList(Model model) {
		model.addAttribute("assets", arepository.findAll());
		return "assetlist";
	}

}
