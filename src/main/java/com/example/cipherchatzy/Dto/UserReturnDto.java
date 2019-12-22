package com.example.cipherchatzy.Dto;


import java.util.Set;

import com.example.cipherchatzy.Model.PhoneNumberModel;
import com.example.cipherchatzy.Model.PhotosModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class UserReturnDto {
	
	private String name;
	private String email;
	private String statusUser = "OFFLINE";
	
	
	@JsonIgnore
	private Set<PhoneNumberModel> allPhoneNumbers;
	
	@JsonIgnore
	private Set<PhotosModel> allPhotosUser;

	public UserReturnDto() {
		
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

	public String getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
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
