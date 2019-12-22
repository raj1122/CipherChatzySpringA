/**
 * 
 */
package com.example.cipherchatzy.Model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax. persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "PHOTOS_USER")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class PhotosModel extends AuditModel {
	
	
	@Id
	@Column(name = "PUS_ID")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq")
	private long id;
	
	@Column(name = "PUS_NAME")
	private String name;
	
	@Column (name = "PUS_URL")
	private String url;
	
	@Column(name = "PUS_MAIN")
	private boolean isMain;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "rus_id")
	@JsonIgnore
	private UserModel userModel;

	public PhotosModel() {
		
	}

	

	public PhotosModel(String name, String url, boolean isMain, UserModel userModel) {
		this.name = name;
		this.url = url;
		this.isMain = isMain;
		this.userModel = userModel;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	
	

	

}
