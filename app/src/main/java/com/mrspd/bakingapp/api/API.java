package com.mrspd.bakingapp.api;


import com.mrspd.bakingapp.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public interface API {
    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getMyRecipes();
}
