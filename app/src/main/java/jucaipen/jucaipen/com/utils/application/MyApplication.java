package jucaipen.jucaipen.com.utils.application;

import android.app.Application;

import com.zhy.changeskin.SkinManager;

import org.xutils.x;

import jucaipen.jucaipen.com.utils.BuildConfig;

/**
 * Created by jucaipen on 16/6/12.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        SkinManager.getInstance().init(this);
    }
}
