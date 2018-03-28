package com.example.wangze;

import android.app.Application;

import com.example.wangze.jwt.XActivityManager;

/**
 * Created by wangze on 2018/3/27.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XActivityManager.getInstance(this).registerDefaultCurrentActivityLifeCircle();
    }
}
