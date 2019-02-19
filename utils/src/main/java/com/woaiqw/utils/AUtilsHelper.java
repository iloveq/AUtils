package com.woaiqw.utils;

import android.app.Application;

import com.woaiqw.utils.core.AppUtils;
import com.woaiqw.utils.core.ImageUtils;
import com.woaiqw.utils.core.KeyboardUtils;
import com.woaiqw.utils.core.NetworkUtils;
import com.woaiqw.utils.core.ToastUtils;
import com.woaiqw.utils.core.UIUtils;

/**
 * Created by haoran on 2019/2/18.
 */
public class AUtilsHelper {

    private AUtilsHelper() {
    }

    private static class Holder {
        private final static AUtilsHelper IN = new AUtilsHelper();
    }

    public static AUtilsHelper get() {
        return Holder.IN;
    }

    public void init(Application app) {

        AppUtils.init(app);
        // utils
        ImageUtils.init(app);
        KeyboardUtils.init(app);
        NetworkUtils.init(app);
        ToastUtils.init(app);
        UIUtils.init(app);

    }

}
