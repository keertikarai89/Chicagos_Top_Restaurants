package edu.depaul.csc472.chicagostoprestaurant;

import android.provider.ContactsContract;

/**
 * Created by keertika on 11/1/2017.
 */

public class Restaurant {

    enum Type { American, Chinese, Italian, Indian }

    String name;
    Type type;
    String shortDescription;
    String longDescription;
    //String website;
    float rating = 4.0f;

    public Restaurant(String name, Type type, String shortDescription, String longDescription) {
        this.name = name;
        this.type = type;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        //this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

   // public float getRating() {
        //return rating;
    //}

    //public void setRating(float rating) {
        //this.rating = rating;
    //}

    public String toString() {
        return name;
    }

    public static int getIconResource(Type type) {
        switch (type) {
            case American:return R.drawable.america;
            case Chinese:return R.drawable.china;
            case Italian: return R.drawable.italy;
            case Indian: return R.drawable.india;
        }
        return -1;
    }

}
