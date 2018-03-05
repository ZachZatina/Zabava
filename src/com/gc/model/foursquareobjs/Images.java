package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

@SerializedName("svg")
@Expose
public String svg;
@SerializedName("png")
@Expose
public String png;

/**
* No args constructor for use in serialization
* 
*/
public Images() {
}

/**
* 
* @param svg
* @param png
*/
public Images(String svg, String png) {
super();
this.svg = svg;
this.png = png;
}

public Images withSvg(String svg) {
this.svg = svg;
return this;
}

public Images withPng(String png) {
this.png = png;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("svg", svg).append("png", png).toString();
}

}