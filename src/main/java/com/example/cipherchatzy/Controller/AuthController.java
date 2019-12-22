package com.example.cipherchatzy.Controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation. Autowired;
import org.springframework. web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Services.UserServices;


@RestController
@RequestMapping("api/auth/")
public class AuthController {
	
	@Autowired
	private UserServices userService;
	
	
	@GetMapping("{email}/{pass)")
	public UserModel coolCars (@PathVariable("email") String email, @PathVariable("pass") String pass) {
		return userService.getUserByEmailAndPass(email, pass);
	}
	
	
	@GetMapping()
	public Collection<UserModel> GetAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/userLogin")
	public Collection<UserModel> RegisterUser() {
		return userService.getAllUsers();
	}

}
