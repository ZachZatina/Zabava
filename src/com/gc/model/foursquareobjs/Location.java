package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Location {

@SerializedName("address")
@Expose
public String address;
@SerializedName("crossStreet")
@Expose
public String crossStreet;
@SerializedName("lat")
@Expose
public Float lat;
@SerializedName("lng")
@Expose
public Float lng;
@SerializedName("distance")
@Expose
public Integer distance;
@SerializedName("postalCode")
@Expose
public String postalCode;
@SerializedName("cc")
@Expose
public String cc;
@SerializedName("city")
@Expose
public String city;
@SerializedName("state")
@Expose
public String state;
@SerializedName("country")
@Expose
public String country;
@SerializedName("formattedAddress")
@Expose
public List<String> formattedAddress = null;

/**
* No args constructor for use in serialization
* 
*/
public Location() {
}

/**
* 
* @param distance
* @param postalCode
* @param address
* @param state
* @param formattedAddress
* @param lng
* @param cc
* @param lat
* @param country
* @param city
* @param crossStreet
*/
public Location(String address, String crossStreet, Float lat, Float lng, Integer distance, String postalCode, String cc, String city, String state, String country, List<String> formattedAddress) {
super();
this.address = address;
this.crossStreet = crossStreet;
this.lat = lat;
this.lng = lng;
this.distance = distance;
this.postalCode = postalCode;
this.cc = cc;
this.city = city;
this.state = state;
this.country = country;
this.formattedAddress = formattedAddress;
}

public Location withAddress(String address) {
this.address = address;
return this;
}

public Location withCrossStreet(String crossStreet) {
this.crossStreet = crossStreet;
return this;
}

public Location withLat(Float lat) {
this.lat = lat;
return this;
}

public Location withLng(Float lng) {
this.lng = lng;
return this;
}

public Location withDistance(Integer distance) {
this.distance = distance;
return this;
}

public Location withPostalCode(String postalCode) {
this.postalCode = postalCode;
return this;
}

public Location withCc(String cc) {
this.cc = cc;
return this;
}

public Location withCity(String city) {
this.city = city;
return this;
}

public Location withState(String state) {
this.state = state;
return this;
}

public Location withCountry(String country) {
this.country = country;
return this;
}

public Location withFormattedAddress(List<String> formattedAddress) {
this.formattedAddress = formattedAddress;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("address", address).append("crossStreet", crossStreet).append("lat", lat).append("lng", lng).append("distance", distance).append("postalCode", postalCode).append("cc", cc).append("city", city).append("state", state).append("country", country).append("formattedAddress", formattedAddress).toString();
}

}
