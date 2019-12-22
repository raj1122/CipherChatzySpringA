/**
 * 
 */
package com.example.cipherchatzy.Dto;

/**
 * @author Raj Kumar
 *
 */
public class ChatReplyReqDto {
	
	private Long id;
	private String reply;
	private String semail;
	public ChatReplyReqDto() {
		
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
	
	
	

	
	
}
