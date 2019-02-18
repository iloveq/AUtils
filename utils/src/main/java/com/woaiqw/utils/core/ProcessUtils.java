package com.woaiqw.utils.core;

import android.app.Application;
import android.content.Context;

/**
 * Created by haoran on 2019/2/18.
 */
public class ProcessUtils {

    public static String getCurrentProcessName(Application application) {
        int pid = android.os.Process.myPid();
        String processName = "";
        android.app.ActivityManager manager = (android.app.ActivityManager) application.getSystemService
                (Context.ACTIVITY_SERVICE);
        for (android.app.ActivityManager.RunningAppProcessInfo process : manager.getRunningAppProcesses()) {
            if (process.pid == pid) {
                processName = process.processName;
            }
        }
        return processName;
    }
    public static boolean isMainProcess(Application application) {
        String packageName = application.getPackageName();
        return packageName.equals(getCurrentProcessName(application));
    }

}
