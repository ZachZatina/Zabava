package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Group_ {

@SerializedName("type")
@Expose
public String type;
@SerializedName("name")
@Expose
public String name;
@SerializedName("count")
@Expose
public Integer count;
@SerializedName("items")
@Expose
public List<Item__> items = null;

/**
* No args constructor for use in serialization
* 
*/
public Group_() {
}

/**
* 
* @param count
* @param items
* @param name
* @param type
*/
public Group_(String type, String name, Integer count, List<Item__> items) {
super();
this.type = type;
this.name = name;
this.count = count;
this.items = items;
}

public Group_ withType(String type) {
this.type = type;
return this;
}

public Group_ withName(String name) {
this.name = name;
return this;
}

public Group_ withCount(Integer count) {
this.count = count;
return this;
}

public Group_ withItems(List<Item__> items) {
this.items = items;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("type", type).append("name", name).append("count", count).append("items", items).toString();
}

}
