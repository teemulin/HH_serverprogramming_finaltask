package fi.teemuli.Assetlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AssetController {
	
	@GetMapping("/")		//To direct user to right page for now
	public String redirect() {
		return "redirect:assetlist";
	}
	
	@RequestMapping(value="assetlist", method=RequestMethod.GET) //could use @GetMapping("/assetlist") instead?
	public String assetList() {
		return "assetlist";
	}

}
