package com.example.uploaddevice;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Bird1 on 16/10/12.
 */
public class DeviceUtils {

    public static DeviceInfo getDeviceInfo(Context context) {
        DeviceInfo deviceInfo = new DeviceInfo();

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        deviceInfo.setImei(tm.getDeviceId());

//        String serial = getProperty();
//        if (TextUtils.isEmpty(serial)) {
//            deviceInfo.setSerialNumber("");
//        } else {
//            deviceInfo.setSerialNumber(serial);
//        }
//
//        String number = tm.getSimSerialNumber();
//        if (TextUtils.isEmpty(number)) {
//            deviceInfo.setSimSerialNumber("");
//        } else {
//            deviceInfo.setSimSerialNumber(number);
//        }

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

        deviceInfo.setModel(android.os.Build.MODEL);
        deviceInfo.setManufacturer(android.os.Build.MANUFACTURER);
        deviceInfo.setHardware(android.os.Build.HARDWARE);
        deviceInfo.setBrand(android.os.Build.BRAND);
        deviceInfo.setRadio(android.os.Build.getRadioVersion());
        deviceInfo.setDevice(android.os.Build.DEVICE);
        deviceInfo.setProduct(android.os.Build.PRODUCT);
        deviceInfo.setBoard(android.os.Build.BOARD);
        deviceInfo.setIncrementa(android.os.Build.VERSION.INCREMENTAL);

//        try {
//            deviceInfo.setChannel(AppBase.channel);
//        } catch (Exception e) {
//
//        }

        deviceInfo.setAndroidVersion(android.os.Build.VERSION.RELEASE);

        Size size = AndroidUtils.getScreenSize(context);
        deviceInfo.setScreenWidth(size.getWidth() + "");
        deviceInfo.setScreenHeight(size.getHeight() + "");

        deviceInfo.setAppVersion(AndroidUtils.getVersionName(context));
        deviceInfo.setFromApp(Media.getFromApp() + "");

        deviceInfo.setCpuAbi(android.os.Build.CPU_ABI);
        deviceInfo.setCpuAbi2(android.os.Build.CPU_ABI2);
        deviceInfo.setFingerprint(android.os.Build.FINGERPRINT);

        deviceInfo.setCreateTime((new Date().getTime()) + "");

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


}
