/**
 * 
 */
package com.example.cipherchatzy.Dto;

/**
 * @author Raj Kumar
 *
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class CMRMainDto {
	
	private Long id;
	private Date createdAt;
	private String reply;
	private String semail;
	private CMRMNameDto userModel;
	private Set<CMRMIdDto> chatModel = new HashSet<>();
	
	public CMRMainDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public Set<CMRMIdDto> getChatModel() {
		return chatModel;
	}

	public void setChatModel(Set<CMRMIdDto> chatModel) {
		this.chatModel = chatModel;
	}
	
	
	
	
	

}
