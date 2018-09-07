package com.simon.study.utils;

import android.os.Environment;

import com.simon.study.base.BaseApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author simon
 * @description:
 * @date 2018/9/7
 * @since 1.0
 */
public class FileUtil {

    /**
     * 内部数据库路径
     */
    public static final String DB_PATH = File.separator + "data"
            + Environment.getDataDirectory().getAbsolutePath() + File.separator
            + BaseApplication.getInstance().getPackageName() + File.separator + "databases" + File.separator;

    /**
     * 外部数据库路径
     */
    public static final String DB_PATH_SD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tdr" + File.separator;


    /**
     * 拷贝内部存储空间的数据库到外部
     *
     * @throws FileNotFoundException
     */
    public static void copyDBFile(String dbName) throws FileNotFoundException {
        File toDir = new File(DB_PATH_SD);   //外部存储文件夹
        if (!toDir.exists()) {
            toDir.mkdirs();
        }

        File toDb = new File(DB_PATH_SD + dbName); //外部存储数据库
        File fromDir = new File(DB_PATH + dbName); //内部存储数据库

        InputStream is;
        OutputStream os;
        is = new FileInputStream(fromDir);
        os = new FileOutputStream(toDb);
        byte[] buffer = new byte[1024];
        int length;
        try {
            /**
             * 拷贝过程
             */
            while ((length = is.read(buffer, 0, buffer.length)) > 0) {
                os.write(buffer, 0, length);
            }

            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
