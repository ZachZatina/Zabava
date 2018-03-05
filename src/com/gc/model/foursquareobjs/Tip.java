package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Tip {

@SerializedName("id")
@Expose
public String id;
@SerializedName("createdAt")
@Expose
public Integer createdAt;
@SerializedName("text")
@Expose
public String text;
@SerializedName("type")
@Expose
public String type;
@SerializedName("logView")
@Expose
public Boolean logView;
@SerializedName("agreeCount")
@Expose
public Integer agreeCount;
@SerializedName("disagreeCount")
@Expose
public Integer disagreeCount;
@SerializedName("todo")
@Expose
public Todo todo;
@SerializedName("user")
@Expose
public User_ user;

/**
* No args constructor for use in serialization
* 
*/
public Tip() {
}

/**
* 
* @param id
* @param text
* @param agreeCount
* @param createdAt
* @param todo
* @param type
* @param user
* @param disagreeCount
* @param logView
*/
public Tip(String id, Integer createdAt, String text, String type, Boolean logView, Integer agreeCount, Integer disagreeCount, Todo todo, User_ user) {
super();
this.id = id;
this.createdAt = createdAt;
this.text = text;
this.type = type;
this.logView = logView;
this.agreeCount = agreeCount;
this.disagreeCount = disagreeCount;
this.todo = todo;
this.user = user;
}

public Tip withId(String id) {
this.id = id;
return this;
}

public Tip withCreatedAt(Integer createdAt) {
this.createdAt = createdAt;
return this;
}

public Tip withText(String text) {
this.text = text;
return this;
}

public Tip withType(String type) {
this.type = type;
return this;
}

public Tip withLogView(Boolean logView) {
this.logView = logView;
return this;
}

public Tip withAgreeCount(Integer agreeCount) {
this.agreeCount = agreeCount;
return this;
}

public Tip withDisagreeCount(Integer disagreeCount) {
this.disagreeCount = disagreeCount;
return this;
}

public Tip withTodo(Todo todo) {
this.todo = todo;
return this;
}

public Tip withUser(User_ user) {
this.user = user;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("createdAt", createdAt).append("text", text).append("type", type).append("logView", logView).append("agreeCount", agreeCount).append("disagreeCount", disagreeCount).append("todo", todo).append("user", user).toString();
}

}
