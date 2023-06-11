package com.oauth.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oauth.implementation.dao.UserRepository;
import com.oauth.implementation.dto.UserLoginDTO;



@Controller
@RequestMapping("/login")
public class LoginController {



    
	@GetMapping
	public String login() {
		return "login";
	}
	

	
}
