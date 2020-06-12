package com.mrspd.bakingapp.ui;


import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.mrspd.bakingapp.BuildConfig;
import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.model.Ingrediants;
import com.mrspd.bakingapp.model.Recipe;
import com.mrspd.bakingapp.model.Step;
import com.mrspd.bakingapp.utiil.COnsty;
import com.mrspd.bakingapp.utiil.customitemclick;
import com.mrspd.bakingapp.widget.WidgetForInDevice;

public class MainActivity2 extends AppCompatActivity implements customitemclick {
    private Recipe result;
    private SharedPreferences s;
    View contextView;
    @Override
    public void onItemClick(int clickedItemIndex) {
        Step step = result.getSteps().get(clickedItemIndex);
        Intent intent = new Intent(this, StepsActivity.class);
        intent.putExtra("Step", step);
        intent.putExtra("recipe_name", result.getName());
        startActivity(intent);

    }

    public String getIngredientString() {
        StringBuilder result = new StringBuilder();
        for (Ingrediants ingredient : this.result.getIngredients()) {
            result.append(ingredient.gethutyf()).append(" ").append(ingredient.getIngredient()).append("\n");
        }
        return result.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Log.d("gghh", "0");
            if (bundle.containsKey("recipe")) {
                Log.d("gghh", "1");
                result = getIntent().getParcelableExtra("recipe");
            }
        }


        setContentView(R.layout.activity_main2);
        setTitle(result.getImage());
         contextView = findViewById(R.id.e2);
        Snackbar snackbar = Snackbar
                .make(contextView, "Sanitise your cooking utensils and wash them 😁", Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    public Recipe getMyBResult() {
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuu, menu);
        s = getSharedPreferences(BuildConfig.APPLICATION_ID, MODE_PRIVATE);
        if ((s.getInt("ID", -1) == result.getId())) {
            menu.findItem(R.id.action_add_widget).setIcon(R.drawable.ic_baseline_undo_24);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem myitem) {

        int id = myitem.getItemId();

        if (id == R.id.action_add_widget) {
            boolean isWidget = (s.getInt(COnsty.P_ID, -1) == result.getId());

            if (isWidget) {
                s.edit()
                        .remove(COnsty.P_ID)
                        .remove(COnsty.P_TITLE)
                        .remove(COnsty.CONTENT_2703)
                        .apply();
                myitem.setIcon(R.drawable.ic_baseline_widgets_24);
                Snackbar snackbar = Snackbar
                        .make(contextView, "Widget Removed😉", Snackbar.LENGTH_SHORT);
                snackbar.show();
            } else {
                s.edit()
                        .putInt(COnsty.P_ID, result.getId())
                        .putString(COnsty.P_TITLE, result.getName())
                        .putString(COnsty.CONTENT_2703, getIngredientString())
                        .apply();
                myitem.setIcon(R.drawable.ic_baseline_undo_24);
                Snackbar snackbar = Snackbar
                        .make(contextView, "Woohoo!!! widget has been created enjoy your tasty meal😋", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }

            ComponentName cpn = new ComponentName(this, WidgetForInDevice.class);
            AppWidgetManager apwn = AppWidgetManager.getInstance(this);
            int[] mymanyids = apwn.getAppWidgetIds(cpn);
            WidgetForInDevice widgetForInDevice = new WidgetForInDevice();
            widgetForInDevice.onUpdate(this, apwn, mymanyids);
        }


        return super.onOptionsItemSelected(myitem);
    }



}