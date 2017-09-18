package com.example.uploaddevice;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;



import java.net.URLEncoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class StringUtils {

    public StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String buildQueryString(String url, Map<String, String> param, boolean urlEncode) {
        try {
            if (param != null) {
                StringBuffer e = new StringBuffer();
                Iterator i$ = param.keySet().iterator();

                while (i$.hasNext()) {
                    String key = (String) i$.next();
                    String value = (String) param.get(key);
                    if (!isEmpty(value)) {
                        if (e.length() > 0) {
                            e.append("&");
                        }

                        if (urlEncode) {
                            e.append(key + "=" + URLEncoder.encode((String) param.get(key), "utf-8"));
                        } else {
                            e.append(key + "=" + value);
                        }
                    }
                }

                if (e.length() > 0) {
                    url = url.contains("?") ? url + "&" : url + "?";
                    url = url + e.toString();
                }
            }

            return url;
        } catch (Exception var7) {
            return null;
        }
    }

    public static String getByteString(int length) {
        double kByte = (double) length / 1024.0D;
        if (kByte > 1024.0D) {
            double mByte = kByte / 1024.0D;
            if (mByte > 1024.0D) {
                double gByte = mByte / 1024.0D;
                return String.format("%.2fG", new Object[]{Double.valueOf(gByte)});
            } else {
                return String.format("%.2fM", new Object[]{Double.valueOf(mByte)});
            }
        } else {
            return String.format("%.0fk", new Object[]{Double.valueOf(kByte)});
        }
    }

    public static String getByteString(long length) {
        double kByte = (double) length / 1024.0D;
        if (kByte > 1024.0D) {
            double mByte = kByte / 1024.0D;
            if (mByte > 1024.0D) {
                double gByte = mByte / 1024.0D;
                return String.format("%.2fG", new Object[]{Double.valueOf(gByte)});
            } else {
                return String.format("%.2fM", new Object[]{Double.valueOf(mByte)});
            }
        } else {
            return String.format("%.0fk", new Object[]{Double.valueOf(kByte)});
        }
    }

    /**
     * 判断是否是正确的用户名（需要判断是否是手机号码或email）
     *
     * @param username
     * @return
     */
    public static boolean validateUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return false;
        } else if (!isMobileNO(username)) {
            return false;
        }

        return true;
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		联通：130、131、132、152、155、156、185、186
		电信：133、153、180、189、（1349卫通）、177
		总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		*/
        String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }

    /**
     * 判断是否是email
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
//		String expr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        String expr = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";
        return Pattern.matches(expr, email);
    }

    public static SpannableStringBuilder textSpan(String text, int start, int end) {
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(text);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        stringBuilder.setSpan(colorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return stringBuilder;
    }


    public static Date stringToDate(String dateString) {
        ParsePosition position = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateValue = simpleDateFormat.parse(dateString, position);
        return dateValue;
    }

}
