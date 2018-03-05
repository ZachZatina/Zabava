package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

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
@SerializedName("photo")
@Expose
public Photo photo;

/**
* No args constructor for use in serialization
* 
*/
public User() {
}

/**
* 
* @param id
* @param lastName
* @param gender
* @param firstName
* @param photo
*/
public User(String id, String firstName, String lastName, String gender, Photo photo) {
super();
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.gender = gender;
this.photo = photo;
}

public User withId(String id) {
this.id = id;
return this;
}

public User withFirstName(String firstName) {
this.firstName = firstName;
return this;
}

public User withLastName(String lastName) {
this.lastName = lastName;
return this;
}

public User withGender(String gender) {
this.gender = gender;
return this;
}

public User withPhoto(Photo photo) {
this.photo = photo;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("gender", gender).append("photo", photo).toString();
}

}
