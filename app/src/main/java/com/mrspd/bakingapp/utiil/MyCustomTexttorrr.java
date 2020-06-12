package com.mrspd.bakingapp.utiil;

import android.annotation.SuppressLint;

import androidx.test.espresso.IdlingResource;


///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
public class MyCustomTexttorrr {


    @SuppressLint("DefaultLocale")
    public static String formatmytext(double d) {
        if (d == (long) d){
            return String.format("%d", (long) d);
        }

        else{
            return String.format("%s", d);
        }

    }

    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
    private static idinggg myslidweres456;

    public static IdlingResource getIdlingResource() {

        if (myslidweres456 == null) {
            myslidweres456 = new idinggg();
        }
        return myslidweres456;
    }

    public static void setIdleResourceTo(boolean isIdleNow) {
        if (myslidweres456 == null) {
            myslidweres456 = new idinggg();
        }
        myslidweres456.setMyID(isIdleNow);
    }
}
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////