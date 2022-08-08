package in.ecom.ekart.clc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ecom.ekart.clc.app.model.User;
import in.ecom.ekart.clc.app.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "user/auth")
	public ResponseEntity<User> findUserByCritieria(@RequestBody User user) {
		User u = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (u != null)
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
		else {
			User user1 = null;
			return new ResponseEntity<User>(user1, HttpStatus.NOT_FOUND);
		}

	}

}
