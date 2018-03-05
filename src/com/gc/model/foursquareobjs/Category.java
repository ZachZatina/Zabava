package com.gc.model.foursquareobjs;



import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {

@SerializedName("id")
@Expose
public String id;
@SerializedName("name")
@Expose
public String name;
@SerializedName("pluralName")
@Expose
public String pluralName;
@SerializedName("shortName")
@Expose
public String shortName;
@SerializedName("icon")
@Expose
public Icon icon;
@SerializedName("primary")
@Expose
public Boolean primary;

/**
* No args constructor for use in serialization
* 
*/
public Category() {
}

/**
* 
* @param id
* @param icon
* @param primary
* @param name
* @param shortName
* @param pluralName
*/
public Category(String id, String name, String pluralName, String shortName, Icon icon, Boolean primary) {
super();
this.id = id;
this.name = name;
this.pluralName = pluralName;
this.shortName = shortName;
this.icon = icon;
this.primary = primary;
}

public Category withId(String id) {
this.id = id;
return this;
}

public Category withName(String name) {
this.name = name;
return this;
}

public Category withPluralName(String pluralName) {
this.pluralName = pluralName;
return this;
}

public Category withShortName(String shortName) {
this.shortName = shortName;
return this;
}

public Category withIcon(Icon icon) {
this.icon = icon;
return this;
}

public Category withPrimary(Boolean primary) {
this.primary = primary;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("name", name).append("pluralName", pluralName).append("shortName", shortName).append("icon", icon).append("primary", primary).toString();
}

}
