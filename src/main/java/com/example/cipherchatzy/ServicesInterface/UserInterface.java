/**
 * 
 */
package com.example.cipherchatzy.ServicesInterface;

import java.util.Collection;

import com.example.cipherchatzy.Dto.RegisterUserDTO;
import com.example.cipherchatzy.Model.UserModel;

import java.util.List;

/**
 * @author Raj Kumar
 *
 */
public interface UserInterface {

	UserModel getUserByEmailAndPass(String email, String pass);

	boolean createRegisterUser(RegisterUserDTO userModel);
	
	public Collection<UserModel> getAllUsers();

}
