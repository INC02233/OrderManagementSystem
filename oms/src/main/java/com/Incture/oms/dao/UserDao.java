package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.User;

public interface UserDao {

	public List<User> getUsers();
	
	public User getUser(String id);
	
	public void saveUser(User user);
	
	public void updateUser(User user, String id);
	
	public void deleteUser(String id);
	
}
