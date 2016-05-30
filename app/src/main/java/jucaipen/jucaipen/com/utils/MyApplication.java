package jucaipen.jucaipen.com.utils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by jucaipen on 16/5/28.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

    }
}
