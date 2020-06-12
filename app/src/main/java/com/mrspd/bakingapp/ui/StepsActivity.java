package com.mrspd.bakingapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.snackbar.Snackbar;
import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.fragments.StepsFragment;
import com.mrspd.bakingapp.model.Step;
import com.mrspd.bakingapp.utiil.COnsty;

public class StepsActivity extends AppCompatActivity {
    private Fragment fragmrnts;
    View contextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        contextView = findViewById(R.id.ggg23);
        Snackbar snackbar = Snackbar
                .make(contextView, "Take care of your Loved ones ❤ During this Covid19 pandamic", Snackbar.LENGTH_LONG);
        snackbar.show();
        Log.d("Step", "Activity");


        //Preserve the state of the of the fragment
        if (savedInstanceState == null) {
            fragmrnts = new StepsFragment();
        } else {
            fragmrnts = getSupportFragmentManager().getFragment(savedInstanceState, COnsty.SFKEY);
        }


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Log.d("Step", "not null - StepActivity");
            if (bundle.containsKey("Step")) {
                Step st2302364 = getIntent().getParcelableExtra("Step");
                String recipeName = getIntent().getStringExtra("recipe_name");

                bundle.putParcelable("Step", st2302364);
                fragmrnts.setArguments(bundle);
            }
        }
        FragmentManager FC = getSupportFragmentManager();
        FC.beginTransaction()
                .replace(R.id.ggg23, fragmrnts)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, COnsty.SFKEY, fragmrnts);
    }
}