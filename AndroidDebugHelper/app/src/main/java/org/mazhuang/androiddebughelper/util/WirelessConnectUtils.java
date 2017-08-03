package org.mazhuang.androiddebughelper.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Lenovo on 2017/8/3.
 */

public abstract class WirelessConnectUtils {
    public static final int RESULT_SUCCEED = 0;
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_PERMISSION_DENIED = 2;

    public static int setAdbTcpPort() {
        int result = RESULT_FAILED;

        DataOutputStream outStream = null;
        BufferedReader errorStream = null;

        try {
            Process process = Runtime.getRuntime().exec("su");
            outStream = new DataOutputStream(process.getOutputStream());
            String command = "setprop service.adb.tcp.port 5555\n";
            outStream.writeBytes(command);
            outStream.flush();

            command = "stop adbd\n";
            outStream.writeBytes(command);
            outStream.flush();

            command = "start adbd\n";
            outStream.writeBytes(command);
            outStream.flush();

            command = "exit\n";
            outStream.writeBytes(command);
            outStream.flush();

            process.waitFor();

            errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String msg = "";
            String line;
            while ((line = errorStream.readLine()) != null) {
                msg += line;
            }
            LogUtils.i("setAdbTcpPort msg: " + msg);
            result = RESULT_SUCCEED;
        } catch (IOException | InterruptedException e) {
            if (e.getMessage().contains("Permission denied")) {
                result = RESULT_PERMISSION_DENIED;
            }
            LogUtils.e(e);
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    LogUtils.e(e);
                }
            }

            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (IOException e) {
                    LogUtils.e(e);
                }
            }
        }

        return result;
    }
}
