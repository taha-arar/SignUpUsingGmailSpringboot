package com.oauth.implementation.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oauth.implementation.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.oauth.implementation.dao.UserRepository;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	UserRepository userRepo;


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {
		System.out.println("**********1********");

		String redirectUrl = null;
		if(authentication.getPrincipal() instanceof DefaultOAuth2User) {
			DefaultOAuth2User  userDetails = (DefaultOAuth2User ) authentication.getPrincipal();
         String username = userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login")+"@gmail.com" ;
          if(!userRepo.findByEmail(username).isPresent()) {
			  Client user = new Client();
			  user.setEmail(username);
			  user.setName(userDetails.getAttribute("name") !=null?userDetails.getAttribute("name"):userDetails.getAttribute("name"));
			  userRepo.save(user);
          }
			System.out.println("**********2********");
			System.out.println(username);
		}  redirectUrl = "/dashboard";
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
