package com.woaiqw.demo;

import android.app.Application;

import com.woaiqw.utils.AUtilsHelper;

/**
 * Created by haoran on 2019/2/18.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AUtilsHelper.get().init(this);
    }
}
