package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reasons {

@SerializedName("count")
@Expose
public Integer count;
@SerializedName("items")
@Expose
public List<Item_> items = null;

/**
* No args constructor for use in serialization
* 
*/
public Reasons() {
}

/**
* 
* @param count
* @param items
*/
public Reasons(Integer count, List<Item_> items) {
super();
this.count = count;
this.items = items;
}

public Reasons withCount(Integer count) {
this.count = count;
return this;
}

public Reasons withItems(List<Item_> items) {
this.items = items;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("count", count).append("items", items).toString();
}

}
