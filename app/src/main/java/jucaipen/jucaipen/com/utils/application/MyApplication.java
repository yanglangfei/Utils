package jucaipen.jucaipen.com.utils.application;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;
import com.zhy.changeskin.SkinManager;

import org.xutils.x;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import jucaipen.jucaipen.com.utils.BuildConfig;
import jucaipen.jucaipen.com.utils.activity.ErrorActivity;
import jucaipen.jucaipen.com.utils.activity.Main;
import jucaipen.jucaipen.com.utils.activity.PhoteActivity;
import jucaipen.jucaipen.com.utils.utils.UILImageLoader;

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
        //文件下载
        FileDownloader.init(this);
        //配置自定义相册 拍照框架
//        ThemeConfig  theme=new ThemeConfig.Builder().build();  //设置主题
//        FunctionConfig function=new FunctionConfig.Builder().build();  //配置功能
//        ImageLoader loader=new UILImageLoader();  //配置ImageLoader
//        CoreConfig config=new CoreConfig.Builder(this,loader,theme).setFunctionConfig(function).build();
//        GalleryFinal.init(config);


    }
}
