package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User_ {

@SerializedName("id")
@Expose
public String id;
@SerializedName("firstName")
@Expose
public String firstName;
@SerializedName("lastName")
@Expose
public String lastName;
@SerializedName("gender")
@Expose
public String gender;

/**
* No args constructor for use in serialization
* 
*/
public User_() {
}

/**
* 
* @param id
* @param lastName
* @param gender
* @param firstName
*/
public User_(String id, String firstName, String lastName, String gender) {
super();
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.gender = gender;
}

public User_ withId(String id) {
this.id = id;
return this;
}

public User_ withFirstName(String firstName) {
this.firstName = firstName;
return this;
}

public User_ withLastName(String lastName) {
this.lastName = lastName;
return this;
}

public User_ withGender(String gender) {
this.gender = gender;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("gender", gender).toString();
}

}
