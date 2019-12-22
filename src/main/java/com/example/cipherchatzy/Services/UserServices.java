/**
 * 
 */
package com.example.cipherchatzy.Services;

/**
 * @author Raj Kumar
 *
 */

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.RegisterUserDTO;
import com.example.cipherchatzy.Exception.ValidationException;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.UserInterface;

@Service
public class UserServices implements UserInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Collection<UserModel> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserModel getUserByEmailAndPass(String email, String pass) {
		return userRepository.findByEmailAndPass(email, pass);
	}

	@Override
	public boolean createRegisterUser( RegisterUserDTO registerDTO) {
		String name = registerDTO.getName ();
		String email = registerDTO.getEmail();
		String EncryptPass = bcryptEncoder.encode(registerDTO.getPass());
		
		UserModel checkUser = userRepository.findByEmail(email);
		if( checkUser != null)
			throw new ValidationException("Usernane already existed");
		UserModel registerNewUser = new UserModel(name,email, EncryptPass);
		userRepository.save(registerNewUser);
		return true;
	
	}

}
