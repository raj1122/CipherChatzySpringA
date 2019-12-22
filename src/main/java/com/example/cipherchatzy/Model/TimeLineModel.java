/**
 * 
 */
package com.example.cipherchatzy.Model;

/**
 * @author Raj Kumar
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TIMELINE")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class TimeLineModel extends AuditModel {

	@Id
	@Column(name = "TML_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private long id;

	@Column(name = "TML_PATH")
	private String path;
	
	@Column(name = "TML_EMAIL")
	private String email;
	
	@Column(name = "TML_TYPE")
	private String timelineType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rus_id")
	@JsonIgnore
	private UserModel userModel;

	public TimeLineModel() {
		
	}

	
	
	public TimeLineModel( String timelineType,  String email,UserModel userModel) {
				
		this.email = email;
		this.timelineType = timelineType;
		this.userModel = userModel;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimelineType() {
		return timelineType;
	}

	public void setTimelineType(String timelineType) {
		this.timelineType = timelineType;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	
	
	
	

}
