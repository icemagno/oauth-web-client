package br.com.cmabreu.dto;

import br.com.cmabreu.model.UserRoles;

public class UserRolesDTO {
	private Long id;
	private String roleName;	

	public UserRolesDTO( UserRoles role ) {
		this.id = role.getId();
		this.roleName = role.getRoleName();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
