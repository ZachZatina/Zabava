package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Group {

@SerializedName("type")
@Expose
public String type;
@SerializedName("name")
@Expose
public String name;
@SerializedName("items")
@Expose
public List<Item> items = null;

/**
* No args constructor for use in serialization
* 
*/
public Group() {
}

/**
* 
* @param items
* @param name
* @param type
*/
public Group(String type, String name, List<Item> items) {
super();
this.type = type;
this.name = name;
this.items = items;
}



public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

public Group withType(String type) {
this.type = type;
return this;
}

public Group withName(String name) {
this.name = name;
return this;
}

public Group withItems(List<Item> items) {
this.items = items;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("type", type).append("name", name).append("items", items).toString();
}

}
