package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item_ {

@SerializedName("summary")
@Expose
public String summary;
@SerializedName("type")
@Expose
public String type;
@SerializedName("reasonName")
@Expose
public String reasonName;

/**
* No args constructor for use in serialization
* 
*/
public Item_() {
}

/**
* 
* @param summary
* @param reasonName
* @param type
*/
public Item_(String summary, String type, String reasonName) {
super();
this.summary = summary;
this.type = type;
this.reasonName = reasonName;
}

public Item_ withSummary(String summary) {
this.summary = summary;
return this;
}

public Item_ withType(String type) {
this.type = type;
return this;
}

public Item_ withReasonName(String reasonName) {
this.reasonName = reasonName;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("summary", summary).append("type", type).append("reasonName", reasonName).toString();
}

}
