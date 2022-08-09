package in.ecom.ekart.clc.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilesController {

	@Value("${msg}")
	private String message;

	@GetMapping("view")
	public String view(Model model) {
		model.addAttribute("message", message);
		return "profiles";
	}

}
