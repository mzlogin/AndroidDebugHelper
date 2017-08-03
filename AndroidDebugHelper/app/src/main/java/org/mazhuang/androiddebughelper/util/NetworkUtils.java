package org.mazhuang.androiddebughelper.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Lenovo on 2017/8/3.
 */

public abstract class NetworkUtils {
    public static String getIpAddress() {
        String result = null;
        try {
            for (Enumeration<NetworkInterface> enumNetInterfaces = NetworkInterface.getNetworkInterfaces(); enumNetInterfaces.hasMoreElements(); ) {
                NetworkInterface netInterface = enumNetInterfaces.nextElement();
                for (Enumeration<InetAddress> enumIpAddress = netInterface.getInetAddresses(); enumIpAddress.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddress.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        result = inetAddress.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            LogUtils.e(e);
        }
        return result;
    }
}
