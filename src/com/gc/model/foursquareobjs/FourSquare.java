package com.gc.model.foursquareobjs;

import java.awt.Menu;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FourSquare {

@SerializedName("meta")
@Expose
public Meta meta;
@SerializedName("response")
@Expose
public Response response;

/**
* No args constructor for use in serialization
* 
*/
public FourSquare() {
}

/**
* 
* @param response
* @param meta
*/
public FourSquare(Meta meta, Response response) {
super();
this.meta = meta;
this.response = response;
}

public FourSquare withMeta(Meta meta) {
this.meta = meta;
return this;
}

public FourSquare withResponse(Response response) {
this.response = response;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("meta", meta).append("response", response).toString();
}

public Meta getMeta() {
	return meta;
}

public void setMeta(Meta meta) {
	this.meta = meta;
}

public Response getResponse() {
	return response;
}

public void setResponse(Response response) {
	this.response = response;
}



}
