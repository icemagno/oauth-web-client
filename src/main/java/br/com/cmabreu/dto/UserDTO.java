package br.com.cmabreu.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.cmabreu.misc.UserRole;
import br.com.cmabreu.model.User;
import br.com.cmabreu.model.UserRoles;


public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String fullName;
	private String password;
	private boolean enabled;
    private List<UserRolesDTO> roles;
    private String profileImage;
	
    public UserDTO( User user ) {
    	this.id = user.getId();
    	this.username = user.getUsername();
    	this.password = user.getPassword();
    	this.enabled = user.isEnabled();
		this.roles = new ArrayList<UserRolesDTO>();
		this.profileImage = user.getProfileImage();
		this.fullName = user.getFullName();
		for( UserRoles ur : user.getRoles() ) {
			this.roles.add( new UserRolesDTO( ur) );
		}
		
	}
    
    public boolean isAdmin() {
    	for ( UserRolesDTO roles : getRoles() ) {
    		if ( roles.getRoleName().equals( UserRole.ROLE_ADMIN ) ) return true;
    	}
    	return false;
    }
    
	public List<UserRolesDTO> getRoles() {
		return roles;
	}

	public void setNodes(List<UserRolesDTO> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	
}
