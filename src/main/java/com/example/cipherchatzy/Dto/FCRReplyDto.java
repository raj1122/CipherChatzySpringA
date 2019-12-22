package com.example.cipherchatzy.Dto;

import java.util.Date;

public class FCRReplyDto {
	
	private Date createdAt;
	private Date updatedAt;
	private Long id;
	private String reply;
	private String semail;
	
	private CMRMNameDto userModel;

	public FCRReplyDto() {
		
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public CMRMNameDto getUserModel() {
		return userModel;
	}

	public void setUserModel(CMRMNameDto userModel) {
		this.userModel = userModel;
	}
	
	
	
	
	

}

