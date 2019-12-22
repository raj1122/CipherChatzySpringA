package com.example.cipherchatzy.Model;



import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence. Entity;
import javax.persistence. FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence. ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence. SequenceGenerator;
import javax.persistence. Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;


@Entity
@Table(name = "CHAT_MESSAGE")
@SequenceGenerator (name = "seq", initialValue = 1, allocationSize = 100)
public class ChatModel extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "CMS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
	private long id;
	
	
	@Column (name = "CMS_SEMAIL")
	private String semail;
	
	@Column (name = "CMS_REMAIL")
	private String remail;
	
	@ManyToOne(fetch = FetchType. LAZY)
	@JoinColumn (name = "CMS_SENDER_ID", referencedColumnName = "RUS_ID")
	@JsonIgnoreProperties ({ "hibernateLazyInitializer", "handler" })
	private UserModel senderUserModel;
	
	@ManyToOne(fetch = FetchType. LAZY)
	@JoinColumn (name = "CMS_RECEIVER_ID", referencedColumnName = "RUS_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private UserModel receiverUserModel;
	
	@ManyToMany(fetch = FetchType. LAZY,
	cascade = {
		CascadeType.PERSIST,
		CascadeType. MERGE
		})
	@JoinTable(
	name = "Chat_reply_join",
	joinColumns =	@JoinColumn (name = "chat_id"
			, referencedColumnName = "CMS_ID"),
	inverseJoinColumns =	@JoinColumn (name = "chat_reply_id",
										referencedColumnName = "CMR_ID" ) 
				)
	private Set<ChatReplyModel> tags = new HashSet<>();


	public ChatModel() {
		
	}

	public ChatModel(String semail2, String remail2, UserModel sendUser, UserModel recvUser,
			HashSet<ChatReplyModel> tags) {
		
		this.semail = semail2;
		this.remail = remail2;
		this.senderUserModel = sendUser;
		this.receiverUserModel = recvUser;
		this.tags = tags;
	}

	public ChatModel(String semail2, String remail2, UserModel sendUser, UserModel recvUser	) {
		
		this.semail = semail2;
		this.remail = remail2;
		this.senderUserModel = sendUser;
		this.receiverUserModel = recvUser;
	
	}
	
public ChatModel(String semail2, String remail2	) {
		
		this.semail = semail2;
		this.remail = remail2;
		
	
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

	public UserModel getSenderUserModel() {
		return senderUserModel;
	}

	public void setSenderUserModel(UserModel senderUserModel) {
		this.senderUserModel = senderUserModel;
	}

	public UserModel getReceiverUserModel() {
		return receiverUserModel;
	}

	public void setReceiverUserModel(UserModel receiverUserModel) {
		this.receiverUserModel = receiverUserModel;
	}

	public Set<ChatReplyModel> getTags() {
		return tags;
	}

	public void setTags(Set<ChatReplyModel> tags) {
		this.tags = tags;
	}
	
	
	
	
	
	
	


}
