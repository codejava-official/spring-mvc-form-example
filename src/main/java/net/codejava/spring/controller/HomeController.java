package net.codejava.spring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.model.User;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> professionList = Arrays.asList("Developer", "Designer", "Architect");
		model.addAttribute("professionList", professionList);
		
		return "Registration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistration(@ModelAttribute("user") User user) {
		System.out.println(user);
		return "RegistrationSuccess";
	}
}
