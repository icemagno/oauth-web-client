package br.com.cmabreu.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.cmabreu.misc.UserRole;


public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String fullName;
	private boolean enabled;
    private List<UserRolesDTO> roles;
    private String profileImage;
    private String funcao;
    private String telefone;
    private String origem;
    private String setor;
	
    @SuppressWarnings("unchecked")
	public UserDTO( Map<String, Object> details ) {
		this.roles = new ArrayList<UserRolesDTO>();
    	
    	for ( Map.Entry<String, Object> entry : details.entrySet() ) {
    	    String key = entry.getKey();
    	    Object value = entry.getValue();

    	    if ( "id".equals( key ) ) {
    	    	this.id = Long.valueOf( (Integer)value );
    	    }
    	    
    	    if ( "username".equals( key ) ) {
    	    	this.username = (String)value ;
    	    }
    	    
    	    if ( "fullName".equals( key ) ) {
    	    	this.fullName = (String)value ;
    	    }

    	    if ( "enabled".equals( key ) ) {
    	    	this.enabled = (Boolean)value ;
    	    }
    	    
    	    if ( "profileImage".equals( key ) ) {
    	    	this.profileImage = (String)value ;
    	    }   	    

    	    if ( "funcao".equals( key ) ) {
    	    	this.funcao = (String)value ;
    	    }    	    
    	 
    	    if ( "roles".equals( key ) ) {
        	    for ( Map<String, String> mp : ( List< Map<String, String> > )value ) {
        	    	UserRolesDTO urdto = new UserRolesDTO( mp );
        	    	this.roles.add( urdto );		
        	    }
    	    }

    	    if ( "funcao".equals( key ) ) {
    	    	this.funcao = (String)value ;
    	    }    	    
    	    if ( "setor".equals( key ) ) {
    	    	this.setor = (String)value ;
    	    }    	    
    	    if ( "telefone".equals( key ) ) {
    	    	this.telefone = (String)value ;
    	    }    	    
    	    if ( "origem".equals( key ) ) {
    	    	this.origem = (String)value ;
    	    }    	    
    	    
    	}	
	}
    
    public boolean isAdmin() {
    	for ( UserRolesDTO roles : getRoles() ) {
    		if ( roles.getRoleName().equals( UserRole.ROLE_ADMIN ) ) return true;
    	}
    	return false;
    }
    
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public void setRoles(List<UserRolesDTO> roles) {
		this.roles = roles;
	}

	
}
