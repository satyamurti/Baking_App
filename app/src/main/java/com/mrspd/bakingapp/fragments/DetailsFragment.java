package com.mrspd.bakingapp.fragments;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.adapter.IngredantsAdapter;
import com.mrspd.bakingapp.adapter.StepAdapter;
import com.mrspd.bakingapp.model.Recipe;
import com.mrspd.bakingapp.ui.MainActivity2;
import com.mrspd.bakingapp.utiil.customitemclick;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */


///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class DetailsFragment extends Fragment {
    private RecyclerView r1;
    private RecyclerView r2;
    private TabHost tbHost;
    private Recipe results;
    private StepAdapter listADapterstep;
    private IngredantsAdapter listAdapterIngretants;

    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
    private customitemclick stepItemClickListener;
    private Context context;
    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment DetailsFragment.
     */

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_details, container, false);
        context = requireContext();

        if (results == null) {
            results = ((MainActivity2) Objects.requireNonNull(getActivity())).getMyBResult();
        }

        LinearLayoutManager lm = new LinearLayoutManager(getContext());

        r1 = view.findViewById(R.id.rv_ingredients);
        r1.setLayoutManager(lm);

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
        LinearLayoutManager lmSteps = new LinearLayoutManager(getContext());
        r2 = view.findViewById(R.id.rv_steps);
        r2.setLayoutManager(lmSteps);

        tbHost = view.findViewById(R.id.ourMainTAbHost);
        tbHost.setup();
        //////////////////////////////////////////////////////////////
        tbHost.addTab(tbHost.newTabSpec("Ingredients")
                .setIndicator("Ingredients")
                .setContent(R.id.LinearLayoutForTabs));
        tbHost.addTab(tbHost.newTabSpec("Steps")
                .setIndicator("Steps")
                .setContent(R.id.StepSTab));


///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
        listAdapterIngretants = new IngredantsAdapter(requireContext(), results.getIngredients());
        r1.setAdapter(listAdapterIngretants);

        listADapterstep = new StepAdapter(requireContext(), results.getSteps(), (int itemClickedIndex) -> {
            stepItemClickListener.onItemClick(itemClickedIndex);

            Log.d("Step", results.getSteps().get(itemClickedIndex).getDescription());
        });

        r2.setAdapter(listADapterstep);


///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            stepItemClickListener = (customitemclick) context;
        } catch (ClassCastException ignored) {
        }
    }

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
}