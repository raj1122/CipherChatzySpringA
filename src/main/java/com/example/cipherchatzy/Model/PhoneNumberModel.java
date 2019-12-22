package com.example.cipherchatzy.Model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence. Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_PHONE_NUMBER")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class PhoneNumberModel extends AuditModel {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "UPN_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
	private long id;
	
	@Column (name = "UPN_PHN_NO")
	private int phoneNumber;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "rus_id")
	@JsonIgnore
	private UserModel userModel;


	public PhoneNumberModel() {
		
	}
	
	


	public PhoneNumberModel(int phoneNumber, UserModel userModel) {		
		this.phoneNumber = phoneNumber;
		this.userModel = userModel;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public UserModel getUserModel() {
		return userModel;
	}


	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	
	
	


}
