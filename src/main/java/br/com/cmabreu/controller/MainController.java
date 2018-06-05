package br.com.cmabreu.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cmabreu.dto.UserLesserDTO;
import br.com.cmabreu.misc.Constants;
import br.com.cmabreu.model.User;
import br.com.cmabreu.repository.UserRepository;

@Controller
public class MainController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	private UserLesserDTO getLoggedUser( HttpSession session ) {
		
		UserLesserDTO user = (UserLesserDTO)session.getAttribute( Constants.USEROBJECT ); 
		if( user == null ) {
			user = whoami();
			session.setAttribute( Constants.USEROBJECT, user );
		} else {
			//
		}
		return user;
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpSession session ) {
		model.addAttribute( "user", getLoggedUser( session ) );
		return "index";
	}	
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(Model model, HttpSession session ) {
		return "loginPage";
	}	

	
	@RequestMapping(value = "/sidebar", method = RequestMethod.GET)
	public String sidebar(Model model, HttpSession session ) {
		return "sidebar";
	}
		

	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(Model model, HttpSession session ) {
		model.addAttribute( "user", getLoggedUser( session ) );
		return "users";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String userProfile( @PathVariable("id") long userId, Model model, HttpSession session ) {
		model.addAttribute( "user", getLoggedUser( session ) );
		User user = null;
		
		Optional<User> optUser = this.userRepository.findById( new Long(userId) );
		if ( optUser.isPresent() ) {
			user = optUser.get();
			UserLesserDTO userDto = new UserLesserDTO( user );
			model.addAttribute( "userToEdit", userDto );
		}
		
		
		return "user";
	}	


	private UserLesserDTO whoami( ) {
		org.springframework.security.core.userdetails.User userDetail = 
				(org.springframework.security.core.userdetails.User)SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getPrincipal();
		
		String userName = userDetail.getUsername();
	    UserLesserDTO user = new UserLesserDTO( this.userRepository.findByName(userName) );
	    return user;
	    
	}	
	
}
