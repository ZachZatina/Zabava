package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Menu {

@SerializedName("type")
@Expose
public String type;
@SerializedName("label")
@Expose
public String label;
@SerializedName("anchor")
@Expose
public String anchor;
@SerializedName("url")
@Expose
public String url;
@SerializedName("mobileUrl")
@Expose
public String mobileUrl;

/**
* No args constructor for use in serialization
* 
*/
public Menu() {
}

/**
* 
* @param label
* @param type
* @param mobileUrl
* @param url
* @param anchor
*/
public Menu(String type, String label, String anchor, String url, String mobileUrl) {
super();
this.type = type;
this.label = label;
this.anchor = anchor;
this.url = url;
this.mobileUrl = mobileUrl;
}

public Menu withType(String type) {
this.type = type;
return this;
}

public Menu withLabel(String label) {
this.label = label;
return this;
}

public Menu withAnchor(String anchor) {
this.anchor = anchor;
return this;
}

public Menu withUrl(String url) {
this.url = url;
return this;
}

public Menu withMobileUrl(String mobileUrl) {
this.mobileUrl = mobileUrl;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("type", type).append("label", label).append("anchor", anchor).append("url", url).append("mobileUrl", mobileUrl).toString();
}

}
