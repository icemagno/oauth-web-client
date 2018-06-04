package br.com.cmabreu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cmabreu.dao.UserDAO;
import br.com.cmabreu.dto.UserDTO;
import br.com.cmabreu.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	@Transactional
	public User loadUserByUsername(String userName) {
		return this.userDao.loadByUsername(userName);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDao.listUsers();
	}

	@Override
	@Transactional
	public List<User> listUsersAdmin() {
		return this.userDao.listUsersAdmin();
	}

	@Override
	@Transactional
	public void addUser(User user) {
		this.userDao.addUser(user);
	}
	
	@Override
	@Transactional	
	public UserDTO getUserById( Long userId ) {
		UserDTO user = new UserDTO( this.userDao.getUserById( userId ) );
		return user;
	}

}
