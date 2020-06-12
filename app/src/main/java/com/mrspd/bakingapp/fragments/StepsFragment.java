package com.mrspd.bakingapp.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.model.Step;
import com.mrspd.bakingapp.utiil.COnsty;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class StepsFragment extends Fragment {
    private Guideline h567;
    private SimpleExoPlayer MyExoPlayer;
    private PlayerView plyerview;
    private boolean tellmewhneready = true;
    private long pcount = -1;
    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
    private Step step;
    private TextView DpDescription;
    private TextView description;


    public StepsFragment() {
        // Required empty public constructor
    }
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
@Override
public void onResume() {
    super.onResume();
    DpDescription.setText(step.getShortDescription());
    description.setText(step.getDescription());

    if (!TextUtils.isEmpty(step.getVideoURL())) {
        initilizingmyPlayer(Uri.parse(step.getVideoURL()));
    } else {
        plyerview.setVisibility(View.INVISIBLE);
        h567.setVisibility(View.INVISIBLE);
    }

}
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(COnsty.SPOSITIINS, pcount);
        outState.putBoolean(COnsty.PLAYBGJ, tellmewhneready);
    }
    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
    @Override
    public void onPause() {
        super.onPause();
        if (MyExoPlayer != null) {
            pcount = MyExoPlayer.getCurrentPosition();
            tellmewhneready = MyExoPlayer.getPlayWhenReady();
            releasePlayer();
        }
    }
    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            step = bundle.getParcelable("Step");
            Log.d("Step", "is not null");

        }

        if (savedInstanceState != null) {
            pcount = savedInstanceState.getLong(COnsty.SPOSITIINS, C.TIME_UNSET);
            tellmewhneready = savedInstanceState.getBoolean(COnsty.PLAYBGJ);

        }
        View view = inflater.inflate(R.layout.fragment_steps, container, false);

        DpDescription = view.findViewById(R.id.tv3333);
        description = view.findViewById(R.id.tv34876);
        h567 = view.findViewById(R.id.GUidelines);
        plyerview = view.findViewById(R.id.ExoPLayerSUggestedByUdacitySIr);
        return view;
    }

    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
    private void releasePlayer() {
        if (MyExoPlayer != null) {
            MyExoPlayer.stop();
            MyExoPlayer.release();
            MyExoPlayer = null;
        }
    }

    private void initilizingmyPlayer(Uri mediaUri) {
        if (MyExoPlayer == null) {
            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            plyerview.setVisibility(View.VISIBLE);
            MyExoPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector, loadControl);
            plyerview.setPlayer(MyExoPlayer);
            String userAgent = Util.getUserAgent(getContext(), "BakingApp");
            MediaSource mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(
                    getContext(), userAgent), new DefaultExtractorsFactory(), null, null);
            MyExoPlayer.prepare(mediaSource);
            if (pcount > 0)
                MyExoPlayer.seekTo(pcount);
            MyExoPlayer.setPlayWhenReady(tellmewhneready);
        }
    }
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////

}