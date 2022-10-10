package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.User;
import com.Incture.oms.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userRepository;
	

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public User getUser(String id) {
		return userRepository.getUser(id);
	}

	@Override
	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

	@Override
	public void updateUser(User user, String id) {
		userRepository.updateUser(user, id);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteUser(id);
	}

}
