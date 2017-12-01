package com.example.uploaddevice;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Copyright © 2017-2018 乐榜
 *
 * @author csx
 *         date 2017/11/23.
 *         desc
 */

public class SpaceUtil {

    /**
     *  availSpaceOfSDC
     * @return
     */
    public static long getAvailSpaceOfSDC() {
        return (calculate(new File(environment()))/ 1024) / 1024;
    }

    /**
     * availSpaceOfData
     * @return
     */
    public static long getAvailSpaceOfData() {
        return (calculate(Environment.getDataDirectory())/1024)/1024;
    }

    public static String environment() {
        return Environment.getExternalStorageDirectory().getPath();
    }
    public static long calculate(File file) {
        if (file == null) {
            return 0;
        }
        File b = getFile(file);
        if (b == null || !b.exists()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(b.getPath());
            return (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static File getFile(File file) {
        if (file != null) {
            do {
                if (file.isDirectory() && file.exists()) {
                    break;
                }
                file = file.getParentFile();
            } while (file != null);
        }
        return file;
    }

}
