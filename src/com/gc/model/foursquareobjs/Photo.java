package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Photo {

@SerializedName("prefix")
@Expose
public String prefix;
@SerializedName("suffix")
@Expose
public String suffix;

/**
* No args constructor for use in serialization
* 
*/
public Photo() {
}

/**
* 
* @param prefix
* @param suffix
*/
public Photo(String prefix, String suffix) {
super();
this.prefix = prefix;
this.suffix = suffix;
}

public Photo withPrefix(String prefix) {
this.prefix = prefix;
return this;
}

public Photo withSuffix(String suffix) {
this.suffix = suffix;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("prefix", prefix).append("suffix", suffix).toString();
}

}
