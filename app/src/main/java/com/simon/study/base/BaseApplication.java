package com.simon.study.base;

import android.app.Application;


/**
 * created by simon
 * date 2018/6/29
 * version code 1.0
 * description:所有module中Application的基类，用于加载或初始化统一的资源库
 */
public class BaseApplication extends Application {

    private static BaseApplication applicationInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;
    }

    /**
     * 获取application对象
     * @return
     */
    public static BaseApplication getInstance() {
        return applicationInstance;
    }

}
