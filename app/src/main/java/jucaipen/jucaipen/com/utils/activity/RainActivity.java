package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;

import jucaipen.jucaipen.com.utils.R;
import me.jamesxu.giftrainview.GiftRainView;

/**
 * Created by jucaipen on 16/6/14.
 *
 *    撒金币效果  git 项目地址  https://github.com/yanglangfei/GiftRainView
 */
public class RainActivity extends Activity {
    private GiftRainView gift_rain_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_rain);
        initView();

    }

    private void initView() {
        gift_rain_view= (GiftRainView) findViewById(R.id.gift_rain_view);
        gift_rain_view.setImages(R.mipmap.ic_launcher,R.mipmap.actionsheet_middle_pressed);
        gift_rain_view.startRain();
        //物体掉落完停止
       // gift_rain_view.stopRainDely();
        //立即停止
       // gift_rain_view.stopRainNow();

    }
}
