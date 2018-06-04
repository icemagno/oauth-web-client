package br.com.cmabreu.dto;

import java.util.ArrayList;
import java.util.List;

public class UserListDTO {
	private List<UserLesserDTO> data;

	public void addUser( UserLesserDTO user ) {
		data.add( user );
	}
	
	public UserListDTO() {
		this.data = new ArrayList<UserLesserDTO>();
	}

	public List<UserLesserDTO> getData() {
		return data;
	}

	public void setData(List<UserLesserDTO> data) {
		this.data = data;
	}
	
	
}
