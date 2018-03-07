package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marks the class as a hibernate entity (mapped class)
@Table(name = "Quest") // maps the class to the DB table specified by the name modifier
public class QuestDTO {
	
	private int questId; // the specific quest generated
	private String locationId; // Foursquare unique identifier
	private String location; // latitude, longitude
	
	public QuestDTO() {
		
	}
	
	public QuestDTO(String locationId, String location) {
		this.locationId = locationId;
		this.location = location;
	}


	@Id // maps the primary key
	@Column(name = "questID") 
	public int getQuestId() {
		return questId;
	}


	public void setQuestId(int questId) {
		this.questId = questId;
	}

	@Column
	public String getLocationId() {
		return locationId;
	}


	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	@Column
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

}
