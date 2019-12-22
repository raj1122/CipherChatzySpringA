/**
 * 
 */
package com.example.cipherchatzy.Services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.UserDTO;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.UserDao;

/**
 * @author Raj Kumar
 *
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
	UserModel loginUser = userDao.findByEmail(username);
	if (loginUser == null) {
		throw new UsernameNotFoundException("User not found with username:"	+ username);
	}
	else
		return new User( username, loginUser.getPass(),new ArrayList<>() );
	}

	public UserModel save(UserDTO user) {

		UserModel newUser = new UserModel();
		newUser.setEmail(user.getUsername());
		newUser.setPass(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);

	}

}
