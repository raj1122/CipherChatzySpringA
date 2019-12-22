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

public class FstChatReciveDto {
	
	private Date createdAt;
	private Date updatedAt;
	private long id;
	private String semail;
	private String remail;
	private CMRMNameDto senderUserModel;
	private CMRMNameDto receiverUserModel;
	private Set<FCRReplyDto> tags = new HashSet<>();
	
	
	public FstChatReciveDto() {
		
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public CMRMNameDto getSenderUserModel() {
		return senderUserModel;
	}
	public void setSenderUserModel(CMRMNameDto senderUserModel) {
		this.senderUserModel = senderUserModel;
	}
	public CMRMNameDto getReceiverUserModel() {
		return receiverUserModel;
	}
	public void setReceiverUserModel(CMRMNameDto receiverUserModel) {
		this.receiverUserModel = receiverUserModel;
	}
	public Set<FCRReplyDto> getTags() {
		return tags;
	}
	public void setTags(Set<FCRReplyDto> tags) {
		this.tags = tags;
	}
	
	
	
	


}
