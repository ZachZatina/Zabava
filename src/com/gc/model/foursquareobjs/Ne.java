package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Ne {

@SerializedName("lat")
@Expose
public Float lat;
@SerializedName("lng")
@Expose
public Float lng;

/**
* No args constructor for use in serialization
* 
*/
public Ne() {
}

/**
* 
* @param lng
* @param lat
*/
public Ne(Float lat, Float lng) {
super();
this.lat = lat;
this.lng = lng;
}

public Ne withLat(Float lat) {
this.lat = lat;
return this;
}

public Ne withLng(Float lng) {
this.lng = lng;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("lat", lat).append("lng", lng).toString();
}

}
