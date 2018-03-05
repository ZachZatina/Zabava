package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeenHere {

@SerializedName("count")
@Expose
public Integer count;
@SerializedName("marked")
@Expose
public Boolean marked;
@SerializedName("lastCheckinExpiredAt")
@Expose
public Integer lastCheckinExpiredAt;

/**
* No args constructor for use in serialization
* 
*/
public BeenHere() {
}

/**
* 
* @param lastCheckinExpiredAt
* @param marked
* @param count
*/
public BeenHere(Integer count, Boolean marked, Integer lastCheckinExpiredAt) {
super();
this.count = count;
this.marked = marked;
this.lastCheckinExpiredAt = lastCheckinExpiredAt;
}

public BeenHere withCount(Integer count) {
this.count = count;
return this;
}

public BeenHere withMarked(Boolean marked) {
this.marked = marked;
return this;
}

public BeenHere withLastCheckinExpiredAt(Integer lastCheckinExpiredAt) {
this.lastCheckinExpiredAt = lastCheckinExpiredAt;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("count", count).append("marked", marked).append("lastCheckinExpiredAt", lastCheckinExpiredAt).toString();
}

}