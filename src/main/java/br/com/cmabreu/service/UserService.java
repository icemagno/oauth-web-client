package br.com.cmabreu.service;

import java.util.List;

import br.com.cmabreu.dto.UserDTO;
import br.com.cmabreu.model.User;

public interface UserService {
	public User loadUserByUsername(String userName);
	public List<User> listUsers();
	public List<User> listUsersAdmin();
	public void addUser(User user);
	public UserDTO getUserById( Long userId );
}
