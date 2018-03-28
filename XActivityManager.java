package com.example.wangze.jwt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wangze on 2018/3/27.
 */

public class XActivityManager {
    private boolean isLog = true;
    private  String TAG = this.getClass().getSimpleName();
    private Application mApplication;
    private static XActivityManager instance;

    private Activity currentActivity;
    private  Application.ActivityLifecycleCallbacks defaultCurrentActivityLifecycleCallbacks;
    private XActivityManager(Application application){
        this.mApplication = application;
    }
    public static XActivityManager getInstance(Application application){
        if (instance == null){
            instance = new XActivityManager(application);
        }
        return instance;
    }


    public Activity getCurrentActivity(){
        return currentActivity;
    }

    public void unregisterDefaultCurrentActivityLifecycleCallbacks(){
        if (defaultCurrentActivityLifecycleCallbacks!=null){
            mApplication.unregisterActivityLifecycleCallbacks(defaultCurrentActivityLifecycleCallbacks);
        }
    }
    public void registerDefaultCurrentActivityLifeCircle(){
        unregisterDefaultCurrentActivityLifecycleCallbacks();
        mApplication.registerActivityLifecycleCallbacks(getDefaultCurrentActivityLifecycleCallbacks());
    }


    private Application.ActivityLifecycleCallbacks getDefaultCurrentActivityLifecycleCallbacks(){
        if (defaultCurrentActivityLifecycleCallbacks == null){
            defaultCurrentActivityLifecycleCallbacks =  new Application.ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivityCreated");

                }

                @Override
                public void onActivityStarted(Activity activity) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivityStarted");
                }

                @Override
                public void onActivityResumed(Activity activity) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivityResumed");
                    Boolean isActivityBeADialog = activity.getWindow().isFloating();
                    //不记录dialogActivity
                    if (!isActivityBeADialog){
                        currentActivity = activity;
                        log("currentActivity ==  :"+activity.getClass().getSimpleName());
                    }


                }

                @Override
                public void onActivityPaused(Activity activity) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivityPaused");
                }

                @Override
                public void onActivityStopped(Activity activity) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivityStopped");
                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivitySaveInstanceState");
                }

                @Override
                public void onActivityDestroyed(Activity activity) {
                    log("activity :"+activity.getClass().getSimpleName() +"  onActivityDestroyed");
                }
            };
        }
        return  defaultCurrentActivityLifecycleCallbacks;

    }


    private void log(String msg){
        if (isLog){
            Log.d(TAG,msg);
        }
    }
}
