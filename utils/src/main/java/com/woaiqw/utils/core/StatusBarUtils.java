package com.woaiqw.utils.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * @author zzy
 * @date 2018/9/18
 */

public class StatusBarUtils {

    public static void setStatusBarFontIconLight(@NonNull Activity activity, boolean isLightIcon) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);

            if(isLightIcon){
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }else{
                activity.getWindow().setStatusBarColor(Color.WHITE);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = activity.getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !isLightIcon) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            activity.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public static int getStatusBarHeight(Context context){
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    /**
     * 运行时获取statusBar的高度，并修正根布局的h
     * @param activity
     * @param vg    根布局，要求必须是FrameLayout的子类
     */
    public static void fixStatusHeight(Activity activity, ViewGroup vg) {
        int h = getStatusBarHeight(activity);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) vg.getLayoutParams();
        lp.setMargins(0, h, 0, 0);
        vg.setLayoutParams(lp);
    }

}
