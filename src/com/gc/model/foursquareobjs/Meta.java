package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Meta {

@SerializedName("code")
@Expose
public Integer code;
@SerializedName("requestId")
@Expose
public String requestId;

/**
* No args constructor for use in serialization
* 
*/
public Meta() {
}

/**
* 
* @param requestId
* @param code
*/
public Meta(Integer code, String requestId) {
super();
this.code = code;
this.requestId = requestId;
}

public Meta withCode(Integer code) {
this.code = code;
return this;
}

public Meta withRequestId(String requestId) {
this.requestId = requestId;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("code", code).append("requestId", requestId).toString();
}

}
