package com.mrspd.bakingapp.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public abstract class RetrofitInstance {
    private static API api;

    public static API getREcipesssInstance(Context context) {
        if (api == null) {
            Gson gson = new GsonBuilder().create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://d17h27t6h515a5.cloudfront.net")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            api = retrofit.create(API.class);

        }
        return api;

    }
}
