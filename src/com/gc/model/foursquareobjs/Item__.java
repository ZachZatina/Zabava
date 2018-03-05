package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item__ {

@SerializedName("id")
@Expose
public String id;
@SerializedName("createdAt")
@Expose
public Integer createdAt;
@SerializedName("prefix")
@Expose
public String prefix;
@SerializedName("suffix")
@Expose
public String suffix;
@SerializedName("width")
@Expose
public Integer width;
@SerializedName("height")
@Expose
public Integer height;
@SerializedName("user")
@Expose
public User user;
@SerializedName("visibility")
@Expose
public String visibility;

/**
* No args constructor for use in serialization
* 
*/
public Item__() {
}

/**
* 
* @param id
* @param height
* @param visibility
* @param createdAt
* @param width
* @param prefix
* @param user
* @param suffix
*/
public Item__(String id, Integer createdAt, String prefix, String suffix, Integer width, Integer height, User user, String visibility) {
super();
this.id = id;
this.createdAt = createdAt;
this.prefix = prefix;
this.suffix = suffix;
this.width = width;
this.height = height;
this.user = user;
this.visibility = visibility;
}

public Item__ withId(String id) {
this.id = id;
return this;
}

public Item__ withCreatedAt(Integer createdAt) {
this.createdAt = createdAt;
return this;
}

public Item__ withPrefix(String prefix) {
this.prefix = prefix;
return this;
}

public Item__ withSuffix(String suffix) {
this.suffix = suffix;
return this;
}

public Item__ withWidth(Integer width) {
this.width = width;
return this;
}

public Item__ withHeight(Integer height) {
this.height = height;
return this;
}

public Item__ withUser(User user) {
this.user = user;
return this;
}

public Item__ withVisibility(String visibility) {
this.visibility = visibility;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("createdAt", createdAt).append("prefix", prefix).append("suffix", suffix).append("width", width).append("height", height).append("user", user).append("visibility", visibility).toString();
}

}
