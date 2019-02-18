package com.woaiqw.utils;

import android.app.Application;

import com.woaiqw.utils.core.ClassUtils;
import com.woaiqw.utils.core.AppUtils;

import java.util.List;

/**
 * Created by haoran on 2019/2/18.
 */
public class AUtilsHelper {

    private AUtilsHelper() {
    }

    private static class Holder {
        private final static AUtilsHelper IN = new AUtilsHelper();
    }

    public AUtilsHelper get() {
        return Holder.IN;
    }

    public void init(Application app) {

        AppUtils.init(app);
        // utils
        try {
            List<IUtils> initList = ClassUtils.getObjectsWithInterface(app, IUtils.class, app.getPackageName());
            for (IUtils util : initList) {
                util.init(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
