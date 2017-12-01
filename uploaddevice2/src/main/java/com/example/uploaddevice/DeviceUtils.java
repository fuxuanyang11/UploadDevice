package com.example.uploaddevice;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Bird1 on 16/10/12.
 */
public class DeviceUtils {

    public static DeviceInfo getDeviceInfo(Context context) {
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

}
