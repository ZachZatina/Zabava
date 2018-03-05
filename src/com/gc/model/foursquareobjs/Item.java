package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item {

@SerializedName("reasons")
@Expose
public Reasons reasons;
@SerializedName("venue")
@Expose
public Venue venue;
@SerializedName("tips")
@Expose
public List<Tip> tips = null;
@SerializedName("referralId")
@Expose
public String referralId;

/**
* No args constructor for use in serialization
* 
*/
public Item() {
}

/**
* 
* @param referralId
* @param tips
* @param venue
* @param reasons
*/
public Item(Reasons reasons, Venue venue, List<Tip> tips, String referralId) {
super();
this.reasons = reasons;
this.venue = venue;
this.tips = tips;
this.referralId = referralId;
}

public Item withReasons(Reasons reasons) {
this.reasons = reasons;
return this;
}

public Item withVenue(Venue venue) {
this.venue = venue;
return this;
}

public Item withTips(List<Tip> tips) {
this.tips = tips;
return this;
}

public Item withReferralId(String referralId) {
this.referralId = referralId;
return this;
}



public Reasons getReasons() {
	return reasons;
}

public void setReasons(Reasons reasons) {
	this.reasons = reasons;
}

public Venue getVenue() {
	return venue;
}

public void setVenue(Venue venue) {
	this.venue = venue;
}

public List<Tip> getTips() {
	return tips;
}

public void setTips(List<Tip> tips) {
	this.tips = tips;
}

public String getReferralId() {
	return referralId;
}

public void setReferralId(String referralId) {
	this.referralId = referralId;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("reasons", reasons).append("venue", venue).append("tips", tips).append("referralId", referralId).toString();
}

}
