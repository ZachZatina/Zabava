package com.gc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marks the class as a hibernate entity (mapped class)
@Table(name = "Quest") // maps the class to the DB table specified by the name modifier
public class QuestDTO implements Serializable {

	private int questId; // the specific quest generated
	private String locationId; // Foursquare unique identifier
	private String location; // latitude, longitude
	private String questName; // User Entered Name
	private String questCode; // Code for Parties to enter
	private Integer creatorId; // the quest owner

	public QuestDTO() {

	}

	public QuestDTO(String locationId, String location) {
		this.locationId = locationId;
		this.location = location;
	}

	@Id // maps the primary key
	@Column(name = "questID")
	@GeneratedValue
	public int getQuestId() {
		return questId;
	}

	public void setQuestId(Integer questId) {
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
	
	@Column
	public String getQuestName() {
		return questName;
	}

	public void setQuestName(String questName) {
		this.questName = questName;
	}

	@Column
	public String getQuestCode() {
		return questCode;
	}

	public void setQuestCode(String questCode) {
		this.questCode = questCode;
	}

	@Column(name="creatorid")
	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	
}
