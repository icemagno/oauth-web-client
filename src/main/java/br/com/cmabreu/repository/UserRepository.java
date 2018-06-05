package br.com.cmabreu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.cmabreu.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findAll();
	public User findByName(String userName);
	public Optional<User> findById( Long id );
	
	/*
	public User loadUserByUsername(String userName);
	public List<User> listUsers();
	public List<User> listUsersAdmin();
	public void addUser(User user);
	public UserDTO getUserById( Long userId );	
	*/
}
