/**
 * 
 */
package com.example.cipherchatzy.Dto;

/**
 * @author Raj Kumar
 *
 */

import java.util.Set;

import com.example.cipherchatzy.Model.PhoneNumberModel;
import com.example.cipherchatzy.Model.PhotosModel;



public class RegisterUserDTO {
	
	private String name;
	private String email;
	private String pass;
	private Set<PhoneNumberModel> allPhoneNumbers;
	private Set<PhotosModel> allPhotosUser;
	public RegisterUserDTO() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Set<PhoneNumberModel> getAllPhoneNumbers() {
		return allPhoneNumbers;
	}
	public void setAllPhoneNumbers(Set<PhoneNumberModel> allPhoneNumbers) {
		this.allPhoneNumbers = allPhoneNumbers;
	}
	public Set<PhotosModel> getAllPhotosUser() {
		return allPhotosUser;
	}
	public void setAllPhotosUser(Set<PhotosModel> allPhotosUser) {
		this.allPhotosUser = allPhotosUser;
	}
	
	

	

}
