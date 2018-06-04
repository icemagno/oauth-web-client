package br.com.cmabreu.dao;

import java.util.List;

import br.com.cmabreu.model.User;

public interface UserDAO {
	 public User loadByUsername(String userName);
	 public List<User> listUsers();
	 public List<User> listUsersAdmin();
	 public void addUser( User user );
	 public User getUserById( Long userId );
}
