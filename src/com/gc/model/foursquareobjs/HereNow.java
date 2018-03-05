package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class HereNow {

@SerializedName("count")
@Expose
public Integer count;
@SerializedName("summary")
@Expose
public String summary;
@SerializedName("groups")
@Expose
public List<Object> groups = null;

/**
* No args constructor for use in serialization
* 
*/
public HereNow() {
}

/**
* 
* @param summary
* @param count
* @param groups
*/
public HereNow(Integer count, String summary, List<Object> groups) {
super();
this.count = count;
this.summary = summary;
this.groups = groups;
}

public HereNow withCount(Integer count) {
this.count = count;
return this;
}

public HereNow withSummary(String summary) {
this.summary = summary;
return this;
}

public HereNow withGroups(List<Object> groups) {
this.groups = groups;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("count", count).append("summary", summary).append("groups", groups).toString();
}

}
