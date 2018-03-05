package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response {

@SerializedName("suggestedRadius")
@Expose
public Integer suggestedRadius;
@SerializedName("headerLocation")
@Expose
public String headerLocation;
@SerializedName("headerFullLocation")
@Expose
public String headerFullLocation;
@SerializedName("headerLocationGranularity")
@Expose
public String headerLocationGranularity;
@SerializedName("query")
@Expose
public String query;
@SerializedName("totalResults")
@Expose
public Integer totalResults;
@SerializedName("suggestedBounds")
@Expose
public SuggestedBounds suggestedBounds;
@SerializedName("groups")
@Expose
public List<Group> groups = null;

/**
* No args constructor for use in serialization
* 
*/
public Response() {
}

/**
* 
* @param totalResults
* @param headerLocationGranularity
* @param query
* @param suggestedBounds
* @param suggestedRadius
* @param headerLocation
* @param headerFullLocation
* @param groups
*/
public Response(Integer suggestedRadius, String headerLocation, String headerFullLocation, String headerLocationGranularity, String query, Integer totalResults, SuggestedBounds suggestedBounds, List<Group> groups) {
super();
this.suggestedRadius = suggestedRadius;
this.headerLocation = headerLocation;
this.headerFullLocation = headerFullLocation;
this.headerLocationGranularity = headerLocationGranularity;
this.query = query;
this.totalResults = totalResults;
this.suggestedBounds = suggestedBounds;
this.groups = groups;
}



public Integer getSuggestedRadius() {
	return suggestedRadius;
}

public void setSuggestedRadius(Integer suggestedRadius) {
	this.suggestedRadius = suggestedRadius;
}

public String getHeaderLocation() {
	return headerLocation;
}

public void setHeaderLocation(String headerLocation) {
	this.headerLocation = headerLocation;
}

public String getHeaderFullLocation() {
	return headerFullLocation;
}

public void setHeaderFullLocation(String headerFullLocation) {
	this.headerFullLocation = headerFullLocation;
}

public String getHeaderLocationGranularity() {
	return headerLocationGranularity;
}

public void setHeaderLocationGranularity(String headerLocationGranularity) {
	this.headerLocationGranularity = headerLocationGranularity;
}

public String getQuery() {
	return query;
}

public void setQuery(String query) {
	this.query = query;
}

public Integer getTotalResults() {
	return totalResults;
}

public void setTotalResults(Integer totalResults) {
	this.totalResults = totalResults;
}

public SuggestedBounds getSuggestedBounds() {
	return suggestedBounds;
}

public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
	this.suggestedBounds = suggestedBounds;
}

public List<Group> getGroups() {
	return groups;
}

public void setGroups(List<Group> groups) {
	this.groups = groups;
}

public Response withSuggestedRadius(Integer suggestedRadius) {
this.suggestedRadius = suggestedRadius;
return this;
}

public Response withHeaderLocation(String headerLocation) {
this.headerLocation = headerLocation;
return this;
}

public Response withHeaderFullLocation(String headerFullLocation) {
this.headerFullLocation = headerFullLocation;
return this;
}

public Response withHeaderLocationGranularity(String headerLocationGranularity) {
this.headerLocationGranularity = headerLocationGranularity;
return this;
}

public Response withQuery(String query) {
this.query = query;
return this;
}

public Response withTotalResults(Integer totalResults) {
this.totalResults = totalResults;
return this;
}

public Response withSuggestedBounds(SuggestedBounds suggestedBounds) {
this.suggestedBounds = suggestedBounds;
return this;
}

public Response withGroups(List<Group> groups) {
this.groups = groups;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("suggestedRadius", suggestedRadius).append("headerLocation", headerLocation).append("headerFullLocation", headerFullLocation).append("headerLocationGranularity", headerLocationGranularity).append("query", query).append("totalResults", totalResults).append("suggestedBounds", suggestedBounds).append("groups", groups).toString();
}

}
