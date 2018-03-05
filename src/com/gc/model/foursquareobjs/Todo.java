package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Todo {

@SerializedName("count")
@Expose
public Integer count;

/**
* No args constructor for use in serialization
* 
*/
public Todo() {
}

/**
* 
* @param count
*/
public Todo(Integer count) {
super();
this.count = count;
}

public Todo withCount(Integer count) {
this.count = count;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("count", count).toString();
}

}
