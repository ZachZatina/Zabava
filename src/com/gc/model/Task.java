package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")

public class Task {
	
	int taskID;
	String lat;
	String lon;
	String taskType;
	String taskDesc;
	String taskAnswer;
	int questID;
	String address;
	String csz;
	String locationName;
	String locationID;


	public Task() {
	}

	public Task(int taskID, String lat, String lon, String taskType, String taskDesc, String taskAnswer, int questID,
			String address, String csz, String locationName, String locationID) {
		this.taskID = taskID;
		this.lat = lat;
		this.lon = lon;
		this.taskType = taskType;
		this.taskDesc = taskDesc;
		this.taskAnswer = taskAnswer;
		this.questID = questID;
		this.address = address;
		this.csz = csz;
		this.locationName = locationName;
		this.locationID = locationID;
	}

	@Id
	@GeneratedValue
	@Column(name="taskID")
	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	@Column(name="lat")
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Column(name="lon")
	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	@Column(name="taskType")
	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name="taskDesc")
	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	@Column(name="taskAnswer")
	public String getTaskAnswer() {
		return taskAnswer;
	}

	public void setTaskAnswer(String taskAnswer) {
		this.taskAnswer = taskAnswer;
	}

	@Column(name="questID")
	public int getQuestID() {
		return questID;
	}

	public void setQuestID(int questID) {
		this.questID = questID;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="csz")
	public String getCsz() {
		return csz;
	}

	public void setCsz(String csz) {
		this.csz = csz;
	}

	@Column(name="locationName")
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Column(name="locationID")
	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	
	
	
	
	
	
}
