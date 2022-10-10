package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.User;
import com.Incture.oms.Service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<List<User>> getUsers() {
		try {
			return new ResponseEntity<List<User>>(this.userService.getUsers(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		try {
			return new ResponseEntity<User>(this.userService.getUser(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<String>("User save Successfully", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/update")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable String id) {
		try {
		userService.updateUser(user, id);
		return new ResponseEntity<String>("User updated Successfully", HttpStatus.ACCEPTED);
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<String>("User deleted Successully", HttpStatus.ACCEPTED);
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
