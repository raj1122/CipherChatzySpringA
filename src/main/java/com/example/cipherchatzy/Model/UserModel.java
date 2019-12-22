/**
 * 
 */
package com.example.cipherchatzy.Model;

/**
 * @author Raj Kumar
 *
 */



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence. Entity;
import javax.persistence.FetchType;
import javax.persistence. Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence. Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "REGISTER_USER")
@SequenceGenerator (name = "seq", initialValue = 1, allocationSize = 100)
public class UserModel extends AuditModel {
	
	@Id
	@Column (name = "RUS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	
	@Column (name = "RUS_NAME")
	private String name;
	
	@Column (name = "RUS_EMAIL")
	private String email;
	
	@Column (name = "RUS_PASS")
	private String pass;
	
	@Column (name = "RUS_STATUS")
	private String statusUser = "OFFLINE";
	
	@OneToMany (mappedBy = "userModel", cascade = CascadeType. ALL, fetch = FetchType. LAZY)
	@JsonIgnore
	private Set<PhoneNumberModel> allPhoneNumbers;
	
	@OneToMany (mappedBy = "userModel", cascade = CascadeType.ALL, fetch = FetchType. LAZY)
	@JsonIgnore
	private Set<PhotosModel> allPhotosUser;

	public UserModel() {
		
	}

	
	
	public UserModel( String name, String email, String pass) {		
		
		this.name = name;
		this.email = email;
		this.pass = pass;
	
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}

	public Set<PhoneNumberModel> getAllPhoneNumbers() {
		return allPhoneNumbers;
	}

	public void setAllPhoneNumbers(Set<PhoneNumberModel> allPhoneNumbers) {
		this.allPhoneNumbers = allPhoneNumbers;
	}

	public Set<PhotosModel> getAllPhotosUser() {
		return allPhotosUser;
	}

	public void setAllPhotosUser(Set<PhotosModel> allPhotosUser) {
		this.allPhotosUser = allPhotosUser;
	}
	
	
	


	
	
}
