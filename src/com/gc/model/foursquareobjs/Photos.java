package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Photos {

@SerializedName("count")
@Expose
public Integer count;
@SerializedName("groups")
@Expose
public List<Group_> groups = null;

/**
* No args constructor for use in serialization
* 
*/
public Photos() {
}

/**
* 
* @param count
* @param groups
*/
public Photos(Integer count, List<Group_> groups) {
super();
this.count = count;
this.groups = groups;
}

public Photos withCount(Integer count) {
this.count = count;
return this;
}

public Photos withGroups(List<Group_> groups) {
this.groups = groups;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("count", count).append("groups", groups).toString();
}

}
