package com.woaiqw.utils.core;

import android.view.KeyEvent;

/**
 * Created by haoran on 2019/2/18.
 */

public class AppExitUtils {


    private long exitTime = 0;

    private long interval = 2000L;

    public AppExitUtils(long interval) {
        this.interval = interval;
    }

    public AppExitUtils() {
        this(2000L);
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > interval) {
                if (onBackPressListener != null) {
                    onBackPressListener.onBackPressedInterval();
                }
                exitTime = System.currentTimeMillis();
            } else {
                if (onBackPressListener != null) {
                    onBackPressListener.onBackPressedFinish();
                }
            }
            return true;
        }
        return false;
    }


    private OnBackPressListener onBackPressListener;


    public void setOnBackPressListener(OnBackPressListener onBackPressListener) {
        this.onBackPressListener = onBackPressListener;
    }

    public interface OnBackPressListener {

        void onBackPressedInterval();

        void onBackPressedFinish();

    }

}
