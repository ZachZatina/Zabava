package com.gc.model.foursquareobjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SuggestedBounds {

@SerializedName("ne")
@Expose
public Ne ne;
@SerializedName("sw")
@Expose
public Sw sw;

/**
* No args constructor for use in serialization
* 
*/
public SuggestedBounds() {
}

/**
* 
* @param ne
* @param sw
*/
public SuggestedBounds(Ne ne, Sw sw) {
super();
this.ne = ne;
this.sw = sw;
}

public SuggestedBounds withNe(Ne ne) {
this.ne = ne;
return this;
}

public SuggestedBounds withSw(Sw sw) {
this.sw = sw;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("ne", ne).append("sw", sw).toString();
}

}
