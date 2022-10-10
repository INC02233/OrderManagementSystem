package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.User;

public interface UserService {

	public List<User> getUsers();
	
	public User getUser(String id);
	
	public void saveUser(User user);
	
	public void updateUser(User user, String id);
	
	public void deleteUser(String id);
}
