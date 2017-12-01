package com.example.uploaddevice;

import android.os.Build;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Copyright © 2017-2018 乐榜
 *
 * @author csx
 *         date 2017/11/23.
 *         desc
 */

public class MemoryUtil {
    private static long b;

    public static long getTotal() {
        if (b <= 0) {
            long e = getTotalMemory();
            if (e >= 0) {
                b = e;
            }
            if (b <= 0) {
                try {
                    b = f() * 1024;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return b;
    }

    private static long getTotalMemory() {
        if (Build.VERSION.SDK_INT >= 16) {
            Long l = (Long) a(ReflectUtils.CLASSNAME_PROCESS, "getTotalMemory", null, new Object[0]);
            if (l != null) {
                return l.longValue();
            }
        }
        return -1;
    }

    public static long getFreeMemory() {
        Long l = (Long) a(ReflectUtils.CLASSNAME_PROCESS, "getFreeMemory", null, new Object[0]);
        if (l != null) {
            return l.longValue();
        }
        return -1;
    }
    public static Object a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method a = a(a(str), str2, (Class[]) clsArr);
            a.setAccessible(true);
            return a.invoke(null, objArr);
        } catch (Throwable e) {
            throw new RuntimeException("invokeStaticMethod exception, className = " + str + ", methodName = " + str2, e);
        }
    }
    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new RuntimeException("getClass exception, className = " + str, e);
        }
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj instanceof Class ? (Class) obj : obj.getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        throw new RuntimeException("getDeclaredMethod exception, object = " + obj + ", methodName = " + str);
    }
    private static long f() throws IOException {
        BufferedReader bufferedReader;
        IOException e;
        FileNotFoundException e2;
        int indexOf;
        int indexOf2;
        Throwable th;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8);
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = readLine;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        indexOf = str.indexOf(58) + 1;
                        indexOf2 = str.indexOf(107);
                        return Long.parseLong(str.substring(indexOf, indexOf2).trim());
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3222) {
                        e3222.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    indexOf = str.indexOf(58) + 1;
                    indexOf2 = str.indexOf(107);
                    return Long.parseLong(str.substring(indexOf, indexOf2).trim());
                }
                return -1;
            }
        } catch (FileNotFoundException e6) {
            e2 = e6;
            bufferedReader = null;
            e2.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                indexOf = str.indexOf(58) + 1;
                indexOf2 = str.indexOf(107);
                return Long.parseLong(str.substring(indexOf, indexOf2).trim());
            }
            return -1;
        } catch (IOException e7) {

            bufferedReader = null;
            e7.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                indexOf = str.indexOf(58) + 1;
                indexOf2 = str.indexOf(107);
                return Long.parseLong(str.substring(indexOf, indexOf2).trim());
            }
            return -1;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            try {
                throw th;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            indexOf = str.indexOf(58) + 1;
            indexOf2 = str.indexOf(107);
            if (indexOf >= 0 && indexOf2 >= 0) {
                return Long.parseLong(str.substring(indexOf, indexOf2).trim());
            }
        }
        return -1;
    }

}
