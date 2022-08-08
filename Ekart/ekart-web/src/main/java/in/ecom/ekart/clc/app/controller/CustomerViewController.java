package in.ecom.ekart.clc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.ecom.ekart.clc.app.beans.Customer;
import in.ecom.ekart.clc.app.service.CustomerService;

@Controller
public class CustomerViewController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "sign-up")
	public String signUpPage(Model model) {
		model.addAttribute("customerForm", new Customer());
		return "signup";
	}

	@PostMapping(value = "registration")
	public String signUp(@ModelAttribute Customer customer, RedirectAttributes attributes) {
		boolean response = customerService.customerRegistration(customer);
		if (response) {
			attributes.addFlashAttribute("success", "Account created!!");
		} else {
			attributes.addFlashAttribute("error", "Something went wrong, try again!!");
		}
		return "redirect:/sign-up";
	}

}
