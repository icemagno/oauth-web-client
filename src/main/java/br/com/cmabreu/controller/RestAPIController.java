package br.com.cmabreu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmabreu.dto.ConfigDTO;
import br.com.cmabreu.dto.UserLesserDTO;
import br.com.cmabreu.dto.UserListDTO;
import br.com.cmabreu.model.User;
import br.com.cmabreu.service.UserService;

@RestController
@RequestMapping(value = "/v1")
public class RestAPIController {
	
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/whoami", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserLesserDTO whoami( ) {
		org.springframework.security.core.userdetails.User userDetail = 
				(org.springframework.security.core.userdetails.User)SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getPrincipal();
		
		String userName = userDetail.getUsername();
	    UserLesserDTO user = new UserLesserDTO( this.userService.loadUserByUsername(userName) );
	    
	    return user;
	    
	}
	

	@RequestMapping(value = "/getconfig", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ConfigDTO getConfig() {
		org.springframework.security.core.userdetails.User userDetail = 
				(org.springframework.security.core.userdetails.User)SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getPrincipal();
		
		String userName = userDetail.getUsername();		
	    UserLesserDTO user = new UserLesserDTO( this.userService.loadUserByUsername(userName) );
	    
	    ConfigDTO config = new ConfigDTO();
	    config.setUser(user);
	    
	    return config;
	    
	}
	

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserListDTO listPhones(Model model) {
	    List<User> users = this.userService.listUsers();
	    UserListDTO uld = new UserListDTO();
	    for( User usr : users  ) {
	    	uld.addUser( new UserLesserDTO( usr) );
	    }
	    return uld;
	}

	
}
