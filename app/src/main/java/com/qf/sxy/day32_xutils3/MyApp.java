package com.qf.sxy.day32_xutils3;

import android.app.Application;

import org.xutils.x;

/**
 * Created by sxy on 2016/11/1.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //做初始化操作
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
