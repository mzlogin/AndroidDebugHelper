package org.mazhuang.androiddebughelper.util;

/**
 * Created by Lenovo on 2017/7/14.
 */

import android.os.Environment;
import android.util.Log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

public class LogUtils {

    private static final String TAG = LogUtils.class.getSimpleName();

    private static Logger gLogger;

    public static void initialize(String logFileName) {
        try {
            LogConfigurator logConfigurator = new LogConfigurator();
            String logFilePath = Environment.getExternalStorageDirectory() + File.separator + logFileName;
            logConfigurator.setFileName(logFilePath);
            logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");
            logConfigurator.setRootLevel(Level.DEBUG);
            logConfigurator.setLevel("org.apache", Level.DEBUG);
            logConfigurator.setMaxFileSize(1024 * 1024 * 5);
            logConfigurator.configure();

            gLogger = Logger.getLogger(LogUtils.class);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void d(Object msg) {
        Log.d(TAG, msg == null ? "" : msg.toString());
        if (gLogger != null && gLogger.isDebugEnabled()) {
            gLogger.debug(msg);
        }
    }

    public static void d(String tag, Object msg) {
        Log.d(tag, msg == null ? "" : msg.toString());
        if (gLogger != null && gLogger.isDebugEnabled()) {
            Logger.getLogger(tag).debug(msg);
        }
    }

    public static void d(String tag, String msg, Throwable t) {
        Log.d(tag, msg);
        if (gLogger != null && gLogger.isDebugEnabled()) {
            Logger.getLogger(tag).debug(msg, t);
        }
    }

    public static void i(Object msg) {
        Log.i(TAG, msg == null ? "" : msg.toString());
        if (gLogger != null && gLogger.isInfoEnabled()) {
            gLogger.info(msg);
        }
    }

    public static void i(String tag, Object msg) {
        Log.i(tag, msg == null ? "" : msg.toString());
        if (gLogger != null && gLogger.isInfoEnabled()) {
            Logger.getLogger(tag).info(msg);
        }
    }

    public static void i(String tag, String msg, Throwable t) {
        Log.i(tag, msg);
        if (gLogger != null && gLogger.isInfoEnabled()) {
            Logger.getLogger(tag).info(msg, t);
        }
    }

    public static void w(Object msg) {
        Log.w(TAG, msg == null ? "" : msg.toString());
        if (gLogger != null) {
            gLogger.warn(msg);
        }
    }

    public static void w(String tag, Object msg ) {
        Log.w(tag, msg == null ? "" : msg.toString());
        if (gLogger != null) {
            Logger.getLogger(tag).warn(msg);
        }
    }

    public static void w(String tag, String msg, Throwable t) {
        Log.w(tag, msg);
        if (gLogger != null) {
            Logger.getLogger(tag).warn(msg, t);
        }
    }

    public static void e(Object msg) {
        Log.e(TAG, msg == null ? "" : msg.toString());
        if (gLogger != null) {
            gLogger.error(msg);
        }
    }

    public static void e(String tag, Object msg) {
        Log.e(tag, msg == null ? "" : msg.toString());
        if (gLogger != null) {
            Logger.getLogger(tag).error(msg);
        }
    }

    public static void e(String tag, Object msg, Throwable e) {
        Log.e(tag, msg == null ? "" : msg.toString());
        if (gLogger != null) {
            Logger.getLogger(tag).error(msg, e);
        }
    }
}
