package com.mrspd.bakingapp.utiil;

import androidx.annotation.Nullable;
import androidx.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
public  class idinggg implements IdlingResource {

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return id785.get();
    }
    @Nullable
    private volatile ResourceCallback callback;

    private AtomicBoolean id785 = new AtomicBoolean(true);
    ///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////
    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback = callback;
    }

    public void setMyID(boolean idleState) {
        id785.set(idleState);
        if (idleState && callback != null) {
            callback.onTransitionToIdle();
        }
    }
}
///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
/////////////////////////////////////////////////////////////////////////