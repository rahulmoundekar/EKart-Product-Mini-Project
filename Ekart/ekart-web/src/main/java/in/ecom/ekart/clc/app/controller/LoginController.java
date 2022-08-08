package in.ecom.ekart.clc.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.ecom.ekart.clc.app.beans.User;
import in.ecom.ekart.clc.app.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping(value = "/sign-in")
	public String loginPage(Model model) {
		model.addAttribute("userForm", new User());
		return "signin";
	}

	@PostMapping(value = "login")
	public String login(Model model, @ModelAttribute("userForm") User user, RedirectAttributes redirectAttributes, HttpSession httpSession)
			throws Exception {
		try {
			User userLogin = loginService.loginService(user);
			if (userLogin != null) {
				httpSession.setAttribute("id", user.getId());
				httpSession.setAttribute("userName", user.getUsername());
				model.addAttribute("user", userLogin);
				return "cart";
			} else {
				redirectAttributes.addFlashAttribute("error", "Bad Credentials, try again!!!");
				return "redirect:/sign-in";
			}
		} catch (Exception e) {
			throw new Exception("Internal Server Error!!");
		}
	}

	@ExceptionHandler(Exception.class)
	public String handleException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Internal Server Error!!");
		return "redirect:/sign-in";
	}
}
