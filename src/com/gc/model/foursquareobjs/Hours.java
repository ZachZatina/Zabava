package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hours {

@SerializedName("status")
@Expose
public String status;
@SerializedName("isOpen")
@Expose
public Boolean isOpen;
@SerializedName("isLocalHoliday")
@Expose
public Boolean isLocalHoliday;

/**
* No args constructor for use in serialization
* 
*/
public Hours() {
}

/**
* 
* @param isLocalHoliday
* @param status
* @param isOpen
*/
public Hours(String status, Boolean isOpen, Boolean isLocalHoliday) {
super();
this.status = status;
this.isOpen = isOpen;
this.isLocalHoliday = isLocalHoliday;
}

public Hours withStatus(String status) {
this.status = status;
return this;
}

public Hours withIsOpen(Boolean isOpen) {
this.isOpen = isOpen;
return this;
}

public Hours withIsLocalHoliday(Boolean isLocalHoliday) {
this.isLocalHoliday = isLocalHoliday;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("status", status).append("isOpen", isOpen).append("isLocalHoliday", isLocalHoliday).toString();
}

}
