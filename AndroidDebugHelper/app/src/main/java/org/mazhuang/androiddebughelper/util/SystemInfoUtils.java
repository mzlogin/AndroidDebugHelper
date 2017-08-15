package org.mazhuang.androiddebughelper.util;

import android.text.TextUtils;

import java.util.Locale;

/**
 * Created by Lenovo on 2017/8/15.
 */

public abstract class SystemInfoUtils {
    /**
     * ref https://developer.android.com/guide/practices/verifying-apps-art.html
     * @return "ART" or "Dalvik" or null when fail
     */
    private static String getVmNameInUse() {
        String result = null;

        String vmVersion = getVmVersionInUse();
        if (!TextUtils.isEmpty(vmVersion)) {
            String[] sections = vmVersion.split("\\.");
            if (Integer.valueOf(sections[0]) >= 2) {
                result = "ART";
            } else {
                result = "Dalvik";
            }
        }

        return result;
    }

    private static String getVmVersionInUse() {
        return System.getProperty("java.vm.version");
    }

    public static String getVmInUse() {
        return String.format(Locale.US, "%s / %s", getVmNameInUse(), getVmVersionInUse());
    }
}
