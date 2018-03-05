package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Price {

@SerializedName("tier")
@Expose
public Integer tier;
@SerializedName("message")
@Expose
public String message;
@SerializedName("currency")
@Expose
public String currency;

/**
* No args constructor for use in serialization
* 
*/
public Price() {
}

/**
* 
* @param message
* @param tier
* @param currency
*/
public Price(Integer tier, String message, String currency) {
super();
this.tier = tier;
this.message = message;
this.currency = currency;
}

public Price withTier(Integer tier) {
this.tier = tier;
return this;
}

public Price withMessage(String message) {
this.message = message;
return this;
}

public Price withCurrency(String currency) {
this.currency = currency;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("tier", tier).append("message", message).append("currency", currency).toString();
}

}
