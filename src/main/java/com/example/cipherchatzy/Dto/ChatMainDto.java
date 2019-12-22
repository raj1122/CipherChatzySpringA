package com.example.cipherchatzy.Dto;


import java.util.List;
public class ChatMainDto {
	
	private String semail;
	private String remail;
	private ChatNameDto senderUserModel;
	private ChatNameDto receiverUserModel;
	private List<ChatMDetDto> allchatsDetails;
	public ChatMainDto() {


		
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
	public ChatNameDto getSenderUserModel() {
		return senderUserModel;
	}
	public void setSenderUserModel(ChatNameDto senderUserModel) {
		this.senderUserModel = senderUserModel;
	}
	public ChatNameDto getReceiverUserModel() {
		return receiverUserModel;
	}
	public void setReceiverUserModel(ChatNameDto receiverUserModel) {
		this.receiverUserModel = receiverUserModel;
	}
	public List<ChatMDetDto> getAllchatsDetails() {
		return allchatsDetails;
	}
	public void setAllchatsDetails(List<ChatMDetDto> allchatsDetails) {
		this.allchatsDetails = allchatsDetails;
	}
	
	
	
	
	
	


}
