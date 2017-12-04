package com.example.uploaddevice;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Bird1 on 16/10/12.
 */
public class DeviceUtils {
    private static String COLOR_OS_ROM_NAME = null;
    public static DeviceInfo getDeviceInfo(Context context,String fromApp, String channel) {
        DeviceInfo deviceInfo = new DeviceInfo();

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        deviceInfo.setImei(tm.getDeviceId());
        deviceInfo.setAndroidId(Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID));

        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        deviceInfo.setWifiMac(info.getMacAddress());
        deviceInfo.setWifiSsid(info.getSSID());
        deviceInfo.setWifiBSsid(info.getBSSID());

        deviceInfo.setPhoneNum(tm.getLine1Number());
        deviceInfo.setIccid(tm.getSimSerialNumber());
        deviceInfo.setImsi(tm.getSubscriberId());
        deviceInfo.setSimStatus(tm.getSimState() + "");
        deviceInfo.setSimOperatorId(tm.getSimOperator());
        deviceInfo.setSimOperatorName(tm.getSimOperatorName() + ":" + getProperty() + ":" + tm.getSimSerialNumber());
        deviceInfo.setSimCountryIso(tm.getSimCountryIso());

        deviceInfo.setModel(Build.MODEL);
        deviceInfo.setManufacturer(Build.MANUFACTURER);
        deviceInfo.setHardware(Build.HARDWARE);
        deviceInfo.setBrand(Build.BRAND);
        deviceInfo.setRadio(Build.getRadioVersion());
        deviceInfo.setDevice(Build.DEVICE);
        deviceInfo.setProduct(Build.PRODUCT);
        deviceInfo.setBoard(Build.BOARD);
        deviceInfo.setIncremental(Build.VERSION.INCREMENTAL);

        deviceInfo.setReleaseVersion(Build.VERSION.RELEASE);

        Size size = AndroidUtils.getScreenSize(context);
        deviceInfo.setScreenWidth(size.getWidth() + "");
        deviceInfo.setScreenHeight(size.getHeight() + "");
        deviceInfo.setXdpi(size.getXdpi());
        deviceInfo.setYdpi(size.getYdpi());
        deviceInfo.setDensity(size.getDensity());
        deviceInfo.setDensityDpi(size.getDensityDpi());

        deviceInfo.setAppVersion(AndroidUtils.getVersionName(context));
        deviceInfo.setFromApp(Media.getFromApp() + "");

        deviceInfo.setCpuAbi(Build.CPU_ABI);
        deviceInfo.setCpuAbi2(Build.CPU_ABI2);
        deviceInfo.setFingerprint(Build.FINGERPRINT);
        deviceInfo.setCreateTime((System.currentTimeMillis()) + "");

        deviceInfo.setDisplay(Build.DISPLAY);
        deviceInfo.setCpu(getCpuInfo());
        deviceInfo.setType(Build.TYPE);
        deviceInfo.setBaseOS(Build.VERSION.BASE_OS);
        deviceInfo.setSdkVersion(Build.VERSION.SDK_INT);
        deviceInfo.setBootloader(Build.BOOTLOADER);
        deviceInfo.setHost(Build.HOST);
        deviceInfo.setAllMemory(MemoryUtil.getTotal());
        deviceInfo.setAvailMemory(MemoryUtil.getFreeMemory());
        deviceInfo.setAvailSpaceOfData(SpaceUtil.getAvailSpaceOfData());
        deviceInfo.setAvailSpaceOfSDC(SpaceUtil.getAvailSpaceOfSDC());


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

        return deviceInfo;
    }

    private final static String kCpuInfoMaxFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";

    public static int getMaxCpuFreq() {
        int result = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(kCpuInfoMaxFreqFilePath);
            br = new BufferedReader(fr);
            String text = br.readLine();
            result = Integer.parseInt(text.trim());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /* 获取CPU名字 */
    public static String getCpuName() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("/proc/cpuinfo");
            br = new BufferedReader(fr);
            String text = br.readLine();
            String[] array = text.split(":\\s+", 2);
            for (int i = 0; i < array.length; i++) {
            }
            return array[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * getSerialNumber
     *
     * @return result is same to getSerialNumber1()
     */
    public static String getSerialNumber() {
        String serial = "";
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            serial = (String) get.invoke(c, "ro.serialno");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serial;
    }

    public static String getProperty() {
        String value = "";
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String) (get.invoke(c, "gsm.serial", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }

    public static String getCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2="";

        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr, 228192);
            while((str2 = localBufferedReader.readLine())!=null){
                if(str2.toLowerCase().contains("hardware")){
                    if(str2.contains(":")) {
                        str2 = str2.split(":")[1].trim().toLowerCase();
                    }
                    break;
                }
            }
            localBufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str2;
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
    public static String getViviCid() {
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
    public static Method getSystemMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
    public static String getViviBuildNumber() {
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
