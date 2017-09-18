package com.example.uploaddevice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.StatFs;
import android.os.StrictMode;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;


/**
 * Created by hhr on 15/12/24.
 */
public class AndroidUtils {

    public static final int IO_BUFFER_SIZE = 8192;
    private static int statusBarHeight = -1;
    private static String uuid;
    private static int sdkVersion;

    private AndroidUtils() {
    }

    public static void hideSoftInput(Context context, IBinder windowToken) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService("input_method");
        imm.hideSoftInputFromWindow(windowToken, 0);
    }

    public static void disableConnectionReuseIfNecessary() {
        if(hasHttpConnectionBug()) {
            System.setProperty("http.keepAlive", "false");
        }

    }

    public static void enableStrictMode() {
        if(VersionUtils.hasGingerbread()) {
            StrictMode.ThreadPolicy.Builder threadPolicyBuilder = (new StrictMode.ThreadPolicy.Builder()).detectAll().penaltyLog();
            if(VersionUtils.hasHoneycomb()) {
                threadPolicyBuilder.penaltyFlashScreen();
            }

            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
        }

    }

    public static int getBitmapSize(Bitmap bitmap) {
        return VersionUtils.hasHoneycombMR1()?bitmap.getByteCount():bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static boolean isExternalStorageRemovable() {
        return VersionUtils.hasGingerbread()? Environment.isExternalStorageRemovable():true;
    }

    public static File getExternalCacheDir(Context context) {
        if(hasExternalCacheDir()) {
            return context.getExternalCacheDir();
        } else {
            String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
            return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
        }
    }

    public static long getUsableSpace(File path) {
        if(VersionUtils.hasGingerbread()) {
            return path.getUsableSpace();
        } else {
            StatFs stats = new StatFs(path.getPath());
            return (long)stats.getBlockSize() * (long)stats.getAvailableBlocks();
        }
    }

    public static int getMemoryClass(Context context) {
        return ((ActivityManager)context.getSystemService("activity")).getMemoryClass();
    }

    public static boolean hasHttpConnectionBug() {
        return Build.VERSION.SDK_INT < 8;
    }

    public static boolean hasExternalCacheDir() {
        return VersionUtils.hasFroyo();
    }

    public static boolean hasActionBar() {
        return VersionUtils.hasHoneycomb();
    }

    public static Size measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int widthSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        view.measure(widthSpec, heightSpec);
        return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return metrics;
    }

    public static float convertDpToPixel(Context context, float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * (float)metrics.densityDpi;
    }

    public static float convertPixelToDp(Context context, float pixel) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return pixel / (float)metrics.densityDpi;
    }

    public static Size getScreenSize(Context context) {
        Point screenSize = new Point();
        WindowManager wm = (WindowManager)context.getSystemService("window");
        Display display = wm.getDefaultDisplay();
        if(Build.VERSION.SDK_INT >= 13) {
            display.getSize(screenSize);
        } else {
            screenSize.x = display.getWidth();
            screenSize.y = display.getHeight();
        }

        return new Size(screenSize.x, screenSize.y);
    }

    public static int getStatusBarHeight(Context context) {
        if(statusBarHeight == -1) {
            try {
                Class e = Class.forName("com.android.internal.R$dimen");
                Object dimen = e.newInstance();
                Field field = e.getField("status_bar_height");
                int reourceId = Integer.parseInt(field.get(dimen).toString());
                statusBarHeight = (int)context.getResources().getDimension(reourceId);
            } catch (Exception var5) {
                ;
            }
        }

        return statusBarHeight;
    }

    public static String getUUID(Context context) {
        if(uuid == null) {
            TelephonyManager tm = (TelephonyManager)context.getSystemService("phone");
            String tmDevice = "" + tm.getDeviceId();
            String androidId = Settings.Secure.getString(context.getContentResolver(), "android_id");
            UUID deviceUuid = new UUID((long)androidId.hashCode(), (long)tmDevice.hashCode() << 32);
            String uniqueId = deviceUuid.toString();
            uuid = DigitalUtils.md5(uniqueId);
        }

        return uuid;
    }

    public static int getSDKVersion() {
        if(sdkVersion == 0) {
            sdkVersion = Build.VERSION.SDK_INT;
        }

        return sdkVersion;
    }

    public static boolean isApplicationInstalled(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        List pkgList = manager.getInstalledPackages(0);

        for(int i = 0; i < pkgList.size(); ++i) {
            PackageInfo pi = (PackageInfo)pkgList.get(i);
            if(pi.packageName.equals(packageName)) {
                return true;
            }
        }

        return false;
    }

    public static String getAppSignatureFingerprint(Context context) {
        try {
            PackageManager e = context.getPackageManager();
            String packageName = context.getPackageName();
            Signature[] signs = e.getPackageInfo(packageName, 64).signatures;
            return signs.length > 0?DigitalUtils.md5(signs[0].toByteArray()):null;
        } catch (Exception var4) {
            return null;
        }
    }

    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }
}
