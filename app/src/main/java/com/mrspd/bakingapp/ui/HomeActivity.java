package com.mrspd.bakingapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.adapter.HomeScreenAdapter;
import com.mrspd.bakingapp.api.API;
import com.mrspd.bakingapp.api.RetrofitInstance;
import com.mrspd.bakingapp.model.Recipe;
import com.mrspd.bakingapp.utiil.MyCustomTexttorrr;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class HomeActivity extends AppCompatActivity {
    private List<Recipe> myrecipies;
    private Call<List<Recipe>> apiCAll;
    private Context context;
    private RecyclerView recyclerView;
    private HomeScreenAdapter listrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hii Welcome...");
        View contextView = findViewById(R.id.gg);
        Snackbar snackbar = Snackbar
                .make(contextView, "Remember to wash your hands before cooking", Snackbar.LENGTH_LONG);
        snackbar.show();
        context = this;
        recyclerView = findViewById(R.id.myUdacityCousreRecipeLIst);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        API api = RetrofitInstance.getREcipesssInstance(this);
        apiCAll = api.getMyRecipes();
        apiCAll.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                Log.d("gghh", "response is there");
                List<Recipe> recipes = response.body();

                listrAdapter = new HomeScreenAdapter(context, recipes, clickedRecipe -> {
                    Recipe recipe = listrAdapter.geRecipeonTHisIndex(clickedRecipe);

                    Intent intent = new Intent(context, MainActivity2.class);
                    intent.putExtra("recipe", recipe);
                    startActivityForResult(intent, 1);
                });
                recyclerView.setAdapter(listrAdapter);

                listrAdapter.notifyDataSetChanged();
                MyCustomTexttorrr.setIdleResourceTo(true);

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d("gghh", "failed");
            }
        });

    }
}