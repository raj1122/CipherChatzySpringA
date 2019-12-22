package com.example.cipherchatzy.Dto;

import com.example.cipherchatzy.Model.UserModel;

public class TimelineDto {
	
	private long id;
	private String path;
	private String email;
	private String timelineType;
	private UserModel userModel;
	public TimelineDto() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTimelineType() {
		return timelineType;
	}
	public void setTimelineType(String timelineType) {
		this.timelineType = timelineType;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	
	
	
	

	

}
