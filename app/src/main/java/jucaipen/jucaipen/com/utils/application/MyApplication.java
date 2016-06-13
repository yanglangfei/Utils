package jucaipen.jucaipen.com.utils.application;

import android.app.Application;

import com.zhy.changeskin.SkinManager;

import org.xutils.x;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import jucaipen.jucaipen.com.utils.BuildConfig;
import jucaipen.jucaipen.com.utils.activity.ErrorActivity;
import jucaipen.jucaipen.com.utils.activity.Main;
import jucaipen.jucaipen.com.utils.activity.PhoteActivity;

/**
 * Created by jucaipen on 16/6/12.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //xUtils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        //换肤
        SkinManager.getInstance().init(this);
        //异常页面处理
        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setEnableAppRestart(true);
        CustomActivityOnCrash.setLaunchErrorActivityWhenInBackground(true);
        CustomActivityOnCrash.setShowErrorDetails(true);
        CustomActivityOnCrash.setErrorActivityClass(ErrorActivity.class);
        CustomActivityOnCrash.setRestartActivityClass(PhoteActivity.class);
    }
}
