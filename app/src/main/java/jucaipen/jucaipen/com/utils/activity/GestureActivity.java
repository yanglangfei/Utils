package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;

import com.alexvasilkov.gestures.views.GestureImageView;

import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/6/14.
 *
 *   支持缩放 放大的控件  ImageView  等
 *        项目git 地址   https://github.com/yanglangfei/GestureViews
 *   */
public class GestureActivity extends Activity{
    private GestureImageView g_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_gesture);
        initView();


    }

    private void initView() {
        g_iv= (GestureImageView) findViewById(R.id.g_iv);
    }
}
