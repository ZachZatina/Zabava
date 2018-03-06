package com.gc.model;

public class Quest {
	
	private int questId; // the specific quest generated
	private String locationId; // Foursquare unique identifier
	private String location; // latitude, longitude
	
	
	public Quest(int questId, String locationId, String location) {
		this.questId = questId;
		this.locationId = locationId;
		this.location = location;
	}


	public int getQuestId() {
		return questId;
	}


	public void setQuestId(int questId) {
		this.questId = questId;
	}


	public String getLocationId() {
		return locationId;
	}


	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	

	
	
	
	

}
