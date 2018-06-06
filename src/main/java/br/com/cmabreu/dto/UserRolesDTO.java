package br.com.cmabreu.dto;

import java.util.Map;

public class UserRolesDTO {
	private Long id;
	private String roleName;	

	public UserRolesDTO( Map<String, String> mp ) {
		
    	for ( Map.Entry<String, String> roleEntry : mp.entrySet() ) {
    	    String roleKey = roleEntry.getKey();
    	    Object roleValue = roleEntry.getValue();
    	    
		    if ( "id".equals( roleKey ) ) {
		    	this.id = Long.valueOf( (Integer) roleValue );
		    }    	    
		    if ( "roleName".equals( roleKey ) ) {
		    	this.roleName = (String)roleValue;
		    }
		    
    	}		
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
