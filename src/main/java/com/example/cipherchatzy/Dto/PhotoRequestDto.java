/**
 * 
 */
package com.example.cipherchatzy.Dto;

/**
 * @author Raj Kumar
 *
 */
public class PhotoRequestDto {
	
	private String name;
	private String url;
	private boolean mainPhoto;
	private Long userId;
	public PhotoRequestDto() {
		
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
	public boolean isMainPhoto() {
		return mainPhoto;
	}
	public void setMainPhoto(boolean mainPhoto) {
		this.mainPhoto = mainPhoto;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
	
	


}
