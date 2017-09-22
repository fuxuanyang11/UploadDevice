package com.example.uploaddevice;

import android.content.Context;
import android.text.TextUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by ASUS on 2017/9/18.
 */

public class DeviceInfoManager {

    private static String COLOR_OS_ROM_NAME = null;

    private  Context mContext;

    private DeviceInfo deviceInfo;

    public DeviceInfoManager(Context context) {
        mContext = context;
        deviceInfo = DeviceUtils.getDeviceInfo(mContext);
    }

    public  Map<String, String> getRequestParam(String fromApp) {
        deviceInfo.setFromApp(fromApp);
        String romName = getRomName();
        int colorOsVersion = getCorlorOSValue();
        if (romName != null) {
            romName = romName + "*" + colorOsVersion;
            deviceInfo.setRoN(romName);
        }

        return deviceInfo.getMapRequestParam();
    }

    private static String getRomName() {
        if (TextUtils.isEmpty(COLOR_OS_ROM_NAME)) {
            try {
                Class cls = Class.forName("android.os.SystemProperties");
                COLOR_OS_ROM_NAME = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.build.display.id", null});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return COLOR_OS_ROM_NAME;
    }

    private static int getCorlorOSValue() {
        int intValue;
        try {
            intValue = ((Integer) ReflectHelp.invokeStatic(ReflectHelp.getClassFromName("com.color.os.ColorBuild"), "getColorOSVERSION", null, null)).intValue();
        } catch (Exception e) {
            intValue = 0;
        }
        if (intValue == 0) {
            try {
                String mobileRomVersion = getMobileRomVersion();
                if (mobileRomVersion.startsWith("V1.4")) {
                    return 3;
                }
                if (mobileRomVersion.startsWith("V2.0")) {
                    return 4;
                }
                if (mobileRomVersion.startsWith("V2.1")) {
                    return 5;
                }
            } catch (Exception e2) {

            }
        }
        return intValue;
    }


    private static String getMobileRomVersion() {
        String mobileRomVersion = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            mobileRomVersion = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.build.version.opporom", "0"});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return mobileRomVersion;
    }
}
