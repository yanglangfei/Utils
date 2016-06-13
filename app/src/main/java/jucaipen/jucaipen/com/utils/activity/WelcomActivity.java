package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.view.CustomMenu;

/**
 * Created by jucaipen on 16/6/13.
 */
public class WelcomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        CustomMenu menu=new CustomMenu(this);
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.mipmap.error);
        menu.setContentView(R.layout.ui_main);
        menu.setLeftMenu(imageView);
        setContentView(menu);
        menu.openLeftMenuIfPossible();
    }
}
