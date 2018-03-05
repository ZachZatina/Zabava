package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Icon {

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
public Icon() {
}



public String getPrefix() {
	return prefix;
}



public void setPrefix(String prefix) {
	this.prefix = prefix;
}



public String getSuffix() {
	return suffix;
}



public void setSuffix(String suffix) {
	this.suffix = suffix;
}



/**
* 
* @param prefix
* @param suffix
*/
public Icon(String prefix, String suffix) {
super();
this.prefix = prefix;
this.suffix = suffix;
}

public Icon withPrefix(String prefix) {
this.prefix = prefix;
return this;
}

public Icon withSuffix(String suffix) {
this.suffix = suffix;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("prefix", prefix).append("suffix", suffix).toString();
}

}
