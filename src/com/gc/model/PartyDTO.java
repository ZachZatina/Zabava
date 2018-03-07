package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ben Fogt
 *
 */

@Entity
@Table(name="party")

public class PartyDTO {
	
	private int partyID;
	private int questID;
	private String partyCode;
	private String partyName;
	
	// Default, empty constructor
	public PartyDTO() {
	}

	// Overridden Constructor with all fields.
	public PartyDTO(int partyID, int questID, String partyCode, String partyName) {
		this.partyID = partyID;
		this.questID = questID;
		this.partyCode = partyCode;
		this.partyName = partyName;
	}

	// Getters and Setters
	@Id
	@GeneratedValue
	@Column(name="partyID")
	public int getPartyID() {
		return partyID;
	}

	public void setPartyID(int partyID) {
		this.partyID = partyID;
	}

	@Column(name="questID")
	public int getQuestID() {
		return questID;
	}

	public void setQuestID(int questID) {
		this.questID = questID;
	}

	@Column(name="partyCode")
	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	@Column(name="partyName")
	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	

}
