/**
 * 
 */
package com.example.cipherchatzy.Model;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence. FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence. Id;
import javax.persistence. JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.cipherchatzy.Dto.ChatReplyReqDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="CHAT_MESSAGE_REPLY")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class ChatReplyModel extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "CMR_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
	private long id;
	
	@Column(name = "CMR_REPLY")
	private String reply;
	
	@Column (name = "CMR_SEMAIL")
	private String semail;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "CMR_SENDER_ID", referencedColumnName = "RUS_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private UserModel userModel;
	
	@ManyToMany (fetch = FetchType. LAZY ,cascade  = {
	CascadeType. PERSIST,
	CascadeType. MERGE
	}, mappedBy = "tags")
	private Set<ChatModel> chatModel = new HashSet<>();
	

		
	public ChatReplyModel() {
		
	}

	public ChatReplyModel(long id, String reply, String semail) {
		this.id = id;
		this.reply = reply;
		this.semail = semail;
	}
	
	


	public ChatReplyModel(String reply, String semail2, UserModel senduser) {
		this.reply = reply;
		this.semail = semail2;
		this.userModel = senduser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public Set<ChatModel> getChatModel() {
		return chatModel;
	}

	public void setChatModel(Set<ChatModel> chatModel) {
		this.chatModel = chatModel;
	}
	
	
	
	
	
	
	
	


}
