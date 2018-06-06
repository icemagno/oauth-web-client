package br.com.cmabreu.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cmabreu.dto.UserDTO;

@Controller
public class MainController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpSession session, Principal principal ) {
		model.addAttribute( "user", getLoggedUser(  principal ) );
		return "index";
	}	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(Model model, HttpSession session, Principal principal ) {
		return index( model,session,principal );
	}	
	
	
	@RequestMapping(value = "/sidebar", method = RequestMethod.GET)
	public String sidebar(Model model, HttpSession session ) {
		return "sidebar";
	}
		
	private UserDTO getLoggedUser( Principal principal ) {
    	OAuth2Authentication user = (OAuth2Authentication)principal;
    	UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)user.getUserAuthentication(); 
    	@SuppressWarnings("unchecked")
		Map<String, Object> details = ( Map<String, Object> ) authentication.getDetails();
    	UserDTO userDto = new UserDTO( details );
	    return userDto;
	}	
	
}
