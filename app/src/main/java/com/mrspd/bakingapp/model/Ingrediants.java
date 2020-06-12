package com.mrspd.bakingapp.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.mrspd.bakingapp.utiil.MyCustomTexttorrr;

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class Ingrediants implements Parcelable {
    private float quantity;
    private String measure;
    private String ingredient;


    protected Ingrediants(Parcel in) {
        quantity = in.readFloat();
        measure = in.readString();
        ingredient = in.readString();
    }

    public static final Creator<Ingrediants> CREATOR = new Creator<Ingrediants>() {
        @Override
        public Ingrediants createFromParcel(Parcel in) {
            return new Ingrediants(in);
        }

        @Override
        public Ingrediants[] newArray(int size) {
            return new Ingrediants[size];
        }
    };

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(quantity);
        dest.writeString(measure);
        dest.writeString(ingredient);
    }
    public String gethutyf() {
        return MyCustomTexttorrr.formatmytext(quantity) + " " + measure;
    }
}