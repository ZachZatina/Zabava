package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creator")
public class CreatorDTO {
	
	int creatorID;
	String email;
		
	public CreatorDTO() {
	}

	public CreatorDTO(int creatorID, String email) {
		this.creatorID = creatorID;
		this.email = email;
	}

	@Id
	@GeneratedValue
	@Column(name="creatorid")
	public int getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(int creatorID) {
		this.creatorID = creatorID;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
