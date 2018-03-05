package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sw {

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
public Sw() {
}

/**
* 
* @param lng
* @param lat
*/
public Sw(Float lat, Float lng) {
super();
this.lat = lat;
this.lng = lng;
}

public Sw withLat(Float lat) {
this.lat = lat;
return this;
}

public Sw withLng(Float lng) {
this.lng = lng;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("lat", lat).append("lng", lng).toString();
}

}
