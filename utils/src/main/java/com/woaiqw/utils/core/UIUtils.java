package com.woaiqw.utils.core;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import com.woaiqw.utils.IUtils;


/**
 * Created by haoran on 2017/4/17.
 * 有关UI的工具类，如获取资源(颜色，字符串，drawable等)，
 * 屏幕宽高，dp与px转换
 */

public class UIUtils implements IUtils {

    private static Application application;

    @Override
    public void init(Application app) {
        application = app;
    }

    private static Resources getResources() {
        return application.getResources();
    }

    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static int getColor(int resId, Resources.Theme theme) {
        return getResources().getColor(resId, theme);
    }

    public static int getColor(String color) {
        return Color.parseColor(color);
    }


    public static Drawable getDrawable(int resTd) {
        return getResources().getDrawable(resTd);
    }


    public static String getString(int resId) {
        return getResources().getString(resId);
    }


    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }


    public static int dp2px(float dp) {
        return (int) (getResources().getDisplayMetrics().density * dp + 0.5f);
    }


    public static int px2dp(float px) {
        return (int) (px / getResources().getDisplayMetrics().density + 0.5f);
    }

    public static int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    public static DisplayMetrics getDisplayMetrics() {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) application.getSystemService(Context.WINDOW_SERVICE);
        assert windowManager != null;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }


}
