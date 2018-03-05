package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Stats {

@SerializedName("checkinsCount")
@Expose
public Integer checkinsCount;
@SerializedName("usersCount")
@Expose
public Integer usersCount;
@SerializedName("tipCount")
@Expose
public Integer tipCount;

/**
* No args constructor for use in serialization
* 
*/
public Stats() {
}

/**
* 
* @param checkinsCount
* @param usersCount
* @param tipCount
*/
public Stats(Integer checkinsCount, Integer usersCount, Integer tipCount) {
super();
this.checkinsCount = checkinsCount;
this.usersCount = usersCount;
this.tipCount = tipCount;
}

public Stats withCheckinsCount(Integer checkinsCount) {
this.checkinsCount = checkinsCount;
return this;
}

public Stats withUsersCount(Integer usersCount) {
this.usersCount = usersCount;
return this;
}

public Stats withTipCount(Integer tipCount) {
this.tipCount = tipCount;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("checkinsCount", checkinsCount).append("usersCount", usersCount).append("tipCount", tipCount).toString();
}

}
