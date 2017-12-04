package com.example.uploaddevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
//        deviceInfo = DeviceUtils.getDeviceInfo(mContext);
    }

    public  Map<String, String> getRequestParam(String fromApp, String channel) {
        deviceInfo.setFromApp(fromApp);
        deviceInfo.setChannel(channel);
        String romName = getRomName();
        int colorOsVersion = getCorlorOSValue();
        if (romName != null) {
            romName = romName + "*" + colorOsVersion;
            deviceInfo.setRomName(romName);
        }

        if(deviceInfo.getRomName().contains("vivo")||deviceInfo.getHost().contains("vivo")){
            deviceInfo.setVivoCid(getViviCid());
            deviceInfo.setVivoBuildNumber(getViviBuildNumber());
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
            intValue = (Integer) ReflectHelp.invokeStatic(ReflectHelp.getClassFromName("com.color.os.ColorBuild"), "getColorOSVERSION", null, null);
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

    /**
     * vivo
     * @return
     */
    public String getViviCid() {
        String sys_path = "/sys/block/mmcblk0/device/cid";
        // 默认值
        String prop = "waiting";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(sys_path));
            prop = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;

    }
    public Method getSystemMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
    public String getViviBuildNumber() {
        String e = "";
        try {
            Method a = getSystemMethod(Class.forName("android.os.SystemProperties"), "get", String.class, String.class);
            if ("yes".equals((String) a.invoke(null, new Object[]{"ro.vivo.net.entry", "no"}))) {
                e = (String) a.invoke(null, new Object[]{"ro.build.netaccess.version", Build.DISPLAY});
            } else {
                String str = (String) a.invoke(null, new Object[]{"ro.vivo.op.entry", "no"});
                if ((TextUtils.isEmpty(str) || !str.contains("CMCC_RW")) && !"CMCC".equals(str)) {
                    str = (String) a.invoke(null, new Object[]{"ro.build.version.bbk", Build.DISPLAY});
                    String str2 = (String) a.invoke(null, new Object[]{"ro.product.customize.bbk", "N"});
                    if (str.indexOf("_") >= 0) {
                        if ("CN-YD".equals(str2)) {
                            str = "PD1421".equals((String) a.invoke(null, new Object[]{"ro.vivo.product.model", "unknown"})) ? str.replaceFirst("PD1421D", "PD1421L") : str.replaceFirst("_", "-YD_");
                        } else if ("CN-DX".equals(str2)) {
                            str = str.replaceFirst("_", "-DX_");
                        } else if ("CN-YD-A".equals(str2)) {
                            str = str.replaceFirst("_", "-YD-A_");
                        } else if ("CN-YD-B".equals(str2)) {
                            str = str.replaceFirst("_", "-YD-B_");
                        }
                    }
                    e = str;
                } else {
                    e = (String) a.invoke(null, new Object[]{"ro.vivo.op.entry.version", Build.DISPLAY});
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return e;
    }
}
