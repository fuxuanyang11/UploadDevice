package com.example.uploaddevice;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Copyright © 2017-2018 乐榜
 *
 * @author csx
 *         date 2017/11/23.
 *         desc
 */

public class ReflectUtils {
    public static final String CLASSNAME_APPLICATIONINFO = "android.content.pm.ApplicationInfo";
    public static final String CLASSNAME_AUDIOSYSTEM = "android.media.AudioSystem";
    public static final String CLASSNAME_HEADERS = "android.net.http.Headers";
    public static final String CLASSNAME_ICONTENTPROVIDER = "android.content.IContentProvider";
    public static final String CLASSNAME_IMOUNTSERVICE_STUB = "android.os.storage.IMountService$Stub";
    public static final String CLASSNAME_IPACKAGEDATAOBSERVER = "android.content.pm.IPackageDataObserver";
    public static final String CLASSNAME_IPACKAGEDELETEOBSERVER = "android.content.pm.IPackageDeleteObserver";
    public static final String CLASSNAME_IPACKAGEINSTALLOBERVER = "android.content.pm.IPackageInstallObserver";
    public static final String CLASSNAME_IPACKAGEMANAGER = "android.content.pm.IPackageManager";
    public static final String CLASSNAME_IPACKAGEMANAGER_STUB = "android.content.pm.IPackageManager$Stub";
    public static final String CLASSNAME_IPACKAGESTATSOBSERVER = "android.content.pm.IPackageStatsObserver";
    public static final String CLASSNAME_PACKAGEINFO = "android.content.pm.PackageInfo";
    public static final String CLASSNAME_PACKAGEMANAGER = "android.content.pm.PackageManager";
    public static final String CLASSNAME_PAGEAGEPARSE = "android.content.pm.PackageParser";
    public static final String CLASSNAME_PAGEAGEPARSE_PACKAGE = "android.content.pm.PackageParser$Package";
    public static final String CLASSNAME_PROCESS = "android.os.Process";
    public static final String CLASSNAME_THREADS = "android.provider.Telephony$Threads";
    public static final String CLASSNAME_THUMBNAILUTILS = "android.media.ThumbnailUtils";

    public static Class classForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new RuntimeException("getClass exception, className = " + str, e);
        }
    }

    public static Context getApplicationContext() {
        Exception e;
        boolean z = false;
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            z = true;
        }

        try {
            return (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e2) {
            e = e2;
        } catch (SecurityException e3) {
            e = e3;
        } catch (IllegalArgumentException e4) {
            e = e4;
        } catch (NoSuchMethodException e5) {
            e = e5;
        } catch (InvocationTargetException e6) {
            e = e6;
        } catch (IllegalAccessException e7) {
            e = e7;
        }

        return null;
    }

    public static Constructor getDeclaredConstructor(String str, Class... clsArr) {
        try {
            Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static Field getDeclaredField(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        throw new RuntimeException("getDeclaredField exception, object = " + obj.getClass().getName() + ", fieldName = " + str);
    }

    public static Method getDeclaredMethod(Object obj, String str, Class... clsArr) {
        Class cls = obj instanceof Class ? (Class) obj : obj.getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        throw new RuntimeException("getDeclaredMethod exception, object = " + obj.getClass().getName() + ", methodName = " + str);
    }

    public static Object getField(Object obj, String str) {
        try {
            return prepareField(obj.getClass(), str).get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getFieldValue(Object obj, String str) {
        try {
            Field declaredField = getDeclaredField(obj, str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable e) {
            throw new RuntimeException("getFieldValue exception, object = " + obj.getClass().getName() + ", fieldName = " + str, e);
        }
    }

    public static int getIntField(Object obj, String str) {
        try {
            return obj.getClass().getDeclaredField(str).getInt(obj);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Method getMethod(Class cls, String str, Class[] clsArr) {
        Method method = null;
        if (str != null && str.length() > 0) {
            try {
                method = cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return method;
    }

    public static Method getMethod(String str, String str2, Class... clsArr) {
        Method method = null;
        try {
            method = Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (ClassNotFoundException e) {
        } catch (SecurityException e2) {
        } catch (NoSuchMethodException e3) {
        }
        return method;
    }

    public static Constructor getObjectConstructor(String str, Class... clsArr) {
        try {
            return Class.forName(str).getConstructor(clsArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getObjectField(Object obj, String str) {
        try {
            return obj.getClass().getDeclaredField(str).get(obj);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getObjectFieldNoDeclared(Object obj, String str) {
        try {
            return obj.getClass().getField(str).get(obj);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getObjectNewInstance(String str, Class[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int getStaticIntField(String str, String str2) {
        try {
            return Class.forName(str).getDeclaredField(str2).getInt(null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getStaticObjectField(String str, String str2) {
        try {
            return Class.forName(str).getDeclaredField(str2).get(null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStaticStringField(String str, String str2) {
        return (String) getStaticObjectField(str, str2);
    }

    public static String getSystemProperties(String str, String str2) {
        Exception e;
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (ClassNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            return str2;
        } catch (SecurityException e3) {
            e = e3;

            e.printStackTrace();
            return str2;
        } catch (IllegalArgumentException e4) {
            e = e4;

            e.printStackTrace();
            return str2;
        } catch (NoSuchMethodException e5) {
            e = e5;

            e.printStackTrace();
            return str2;
        } catch (IllegalAccessException e6) {
            e = e6;

            e.printStackTrace();
            return str2;
        } catch (InvocationTargetException e7) {
            e = e7;

            e.printStackTrace();
            return str2;
        }
    }

    public static Object invoke(Object obj, Method method, Object... objArr) {
        Exception e;
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalArgumentException e2) {
            e = e2;

            return null;
        } catch (IllegalAccessException e3) {
            e = e3;

            return null;
        } catch (InvocationTargetException e4) {
            e = e4;

            return null;
        }
    }

    public static Object invokeMethod(Object obj, String str, Class[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = getDeclaredMethod(obj, str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable e) {
            throw new RuntimeException("invokeMethod exception, receiver = " + obj.getClass().getName() + ", methodName = " + str, e);
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = getDeclaredMethod(classForName(str), str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Throwable e) {
            throw new RuntimeException("invokeStaticMethod exception, className = " + str + ", methodName = " + str2, e);
        }
    }

    public static void modifyPushBigContentView(Object obj, String str, Object obj2) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static void modifyPushPriority(Object obj, String str, Object obj2) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static Field prepareField(Class cls, String str) {
        if (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } finally {
                cls.getSuperclass();
            }
        }
        return null;
    }

    public static void setField(Object obj, String str, Object obj2) {
        try {
            prepareField(obj.getClass(), str).set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setFieldValue(Object obj, String str, Object obj2) {
        try {
            Field declaredField = getDeclaredField(obj, str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Throwable e) {
            throw new RuntimeException("setFieldValue exception, object = " + obj.getClass().getName() + ", fieldName = " + str, e);
        }
    }

    public static Object stubAsInterface(Class cls, IBinder iBinder) {
        try {
            return cls.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Object stubAsInterface(String str, IBinder iBinder) {
        return stubAsInterface(classForName(str), iBinder);
    }

    public static void windowDismissed(InputMethodManager inputMethodManager, IBinder iBinder) {
        try {
            inputMethodManager.getClass().getMethod("windowDismissed", new Class[]{IBinder.class}).invoke(inputMethodManager, new Object[]{iBinder});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
