package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Contact {

@SerializedName("phone")
@Expose
public String phone;
@SerializedName("formattedPhone")
@Expose
public String formattedPhone;

/**
* No args constructor for use in serialization
* 
*/
public Contact() {
}

/**
* 
* @param phone
* @param formattedPhone
*/
public Contact(String phone, String formattedPhone) {
super();
this.phone = phone;
this.formattedPhone = formattedPhone;
}

public Contact withPhone(String phone) {
this.phone = phone;
return this;
}

public Contact withFormattedPhone(String formattedPhone) {
this.formattedPhone = formattedPhone;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("phone", phone).append("formattedPhone", formattedPhone).toString();
}

}
