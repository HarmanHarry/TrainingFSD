package com.eval.coronakit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Users;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userService;
	
	@RequestMapping("/")
	public String index() {
		return  "index";		
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();

			model.addAttribute("username", auth.getName());
			model.addAttribute("role", role);

		Users user=userService.findByUsername(auth.getName());
		session.setAttribute("username", user.getUsername());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("contact", user.getContact());
		}
		return  "main-menu";
	}
}
