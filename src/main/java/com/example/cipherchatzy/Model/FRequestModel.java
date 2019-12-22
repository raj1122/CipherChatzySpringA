/**
 * 
 */
package com.example.cipherchatzy.Model;

/**
 * @author Raj Kumar
 *
 */


import javax.persistence.Column;
import javax.persistence. Entity;
import javax.persistence. FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence. Id;
import javax.persistence.JoinColumn;
import javax.persistence. ManyToOne;
import javax.persistence. SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "FRIEND_REQUEST")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class FRequestModel extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FRQ_ID")
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "seq")
	private Long id;
		
	@Column (name = "FRQ_S_EMAIL")
	private String semail;
	
	@Column (name = "FRQ_R_EMAIL")
	private String remail;
	
	@Column(name = "FRQ_STATUS")
	private String statusUser;
	
	@Column(name = "FRQ_DECLINEBY")	
	private String declineby;
	
	@Column(name = "FRQ_ACCEPTBY")
	private String acceptby;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "rus_id")
	@JsonIgnoreProperties({ "hibernatelazyInitializer", "handler" })
	private UserModel senderUserModel;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "CMS_RECEIVER_ID", referencedColumnName = "RUS_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private UserModel receiverUserModel;


	public FRequestModel() {
		
	}

	
	
	public FRequestModel(String semail, String remail, String statusUser) {
		
		this.semail = semail;
		this.remail = remail;
		this.statusUser = statusUser;
	}
	
	



	public FRequestModel(String semail, String remail, String statusUser, UserModel senderUserModel,
			UserModel receiverUserModel) {		
		this.semail = semail;
		this.remail = remail;
		this.statusUser = statusUser;
		this.senderUserModel = senderUserModel;
		this.receiverUserModel = receiverUserModel;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}



	public String getDeclineby() {
		return declineby;
	}



	public void setDeclineby(String declineby) {
		this.declineby = declineby;
	}



	public String getAcceptby() {
		return acceptby;
	}



	public void setAcceptby(String acceptby) {
		this.acceptby = acceptby;
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
	
	
	
	
	
	
	
	


}
