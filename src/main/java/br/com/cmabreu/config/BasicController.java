package br.com.cmabreu.config;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {

	@RequestMapping(value = "/securedPage", method = RequestMethod.GET)
	public String securedPage(Model model, HttpSession session ) {
		model.addAttribute( "user", whoami( ) );
		return "securedPage";
	}	
	
	private User whoami( ) {
		User userDetail = 
				(org.springframework.security.core.userdetails.User)SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getPrincipal();
		
	    return userDetail;
	    
	}	
	
}
