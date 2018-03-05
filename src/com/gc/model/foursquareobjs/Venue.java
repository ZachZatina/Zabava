package com.gc.model.foursquareobjs;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

@SerializedName("id")
@Expose
public String id;
@SerializedName("name")
@Expose
public String name;
@SerializedName("contact")
@Expose
public Contact contact;
@SerializedName("location")
@Expose
public Location location;
@SerializedName("categories")
@Expose
public List<Category> categories = null;
@SerializedName("verified")
@Expose
public Boolean verified;
@SerializedName("stats")
@Expose
public Stats stats;
@SerializedName("url")
@Expose
public String url;
@SerializedName("price")
@Expose
public Price price;
@SerializedName("hasMenu")
@Expose
public Boolean hasMenu;
@SerializedName("rating")
@Expose
public Float rating;
@SerializedName("ratingColor")
@Expose
public String ratingColor;
@SerializedName("ratingSignals")
@Expose
public Integer ratingSignals;
@SerializedName("menu")
@Expose
public Menu menu;
@SerializedName("allowMenuUrlEdit")
@Expose
public Boolean allowMenuUrlEdit;
@SerializedName("beenHere")
@Expose
public BeenHere beenHere;
@SerializedName("hours")
@Expose
public Hours hours;
@SerializedName("photos")
@Expose
public Photos photos;
@SerializedName("hereNow")
@Expose
public HereNow hereNow;

/**
* No args constructor for use in serialization
* 
*/
public Venue() {
}

/**
* 
* @param ratingSignals
* @param location
* @param ratingColor
* @param hours
* @param stats
* @param hasMenu
* @param menu
* @param allowMenuUrlEdit
* @param hereNow
* @param contact
* @param url
* @param photos
* @param id
* @param price
* @param verified
* @param name
* @param categories
* @param beenHere
* @param rating
*/
public Venue(String id, String name, Contact contact, Location location, List<Category> categories, Boolean verified, Stats stats, String url, Price price, Boolean hasMenu, Float rating, String ratingColor, Integer ratingSignals, Menu menu, Boolean allowMenuUrlEdit, BeenHere beenHere, Hours hours, Photos photos, HereNow hereNow) {
super();
this.id = id;
this.name = name;
this.contact = contact;
this.location = location;
this.categories = categories;
this.verified = verified;
this.stats = stats;
this.url = url;
this.price = price;
this.hasMenu = hasMenu;
this.rating = rating;
this.ratingColor = ratingColor;
this.ratingSignals = ratingSignals;
this.menu = menu;
this.allowMenuUrlEdit = allowMenuUrlEdit;
this.beenHere = beenHere;
this.hours = hours;
this.photos = photos;
this.hereNow = hereNow;
}

public Venue withId(String id) {
this.id = id;
return this;
}

public Venue withName(String name) {
this.name = name;
return this;
}

public Venue withContact(Contact contact) {
this.contact = contact;
return this;
}

public Venue withLocation(Location location) {
this.location = location;
return this;
}

public Venue withCategories(List<Category> categories) {
this.categories = categories;
return this;
}

public Venue withVerified(Boolean verified) {
this.verified = verified;
return this;
}

public Venue withStats(Stats stats) {
this.stats = stats;
return this;
}

public Venue withUrl(String url) {
this.url = url;
return this;
}

public Venue withPrice(Price price) {
this.price = price;
return this;
}

public Venue withHasMenu(Boolean hasMenu) {
this.hasMenu = hasMenu;
return this;
}

public Venue withRating(Float rating) {
this.rating = rating;
return this;
}

public Venue withRatingColor(String ratingColor) {
this.ratingColor = ratingColor;
return this;
}

public Venue withRatingSignals(Integer ratingSignals) {
this.ratingSignals = ratingSignals;
return this;
}

public Venue withMenu(Menu menu) {
this.menu = menu;
return this;
}

public Venue withAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
this.allowMenuUrlEdit = allowMenuUrlEdit;
return this;
}

public Venue withBeenHere(BeenHere beenHere) {
this.beenHere = beenHere;
return this;
}

public Venue withHours(Hours hours) {
this.hours = hours;
return this;
}

public Venue withPhotos(Photos photos) {
this.photos = photos;
return this;
}

public Venue withHereNow(HereNow hereNow) {
this.hereNow = hereNow;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("name", name).append("contact", contact).append("location", location).append("categories", categories).append("verified", verified).append("stats", stats).append("url", url).append("price", price).append("hasMenu", hasMenu).append("rating", rating).append("ratingColor", ratingColor).append("ratingSignals", ratingSignals).append("menu", menu).append("allowMenuUrlEdit", allowMenuUrlEdit).append("beenHere", beenHere).append("hours", hours).append("photos", photos).append("hereNow", hereNow).toString();
}

}
