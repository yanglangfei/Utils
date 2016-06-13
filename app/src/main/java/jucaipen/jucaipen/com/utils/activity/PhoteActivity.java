package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.bm.library.Info;
import com.bm.library.PhotoView;
import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/5/31.
 */
public class PhoteActivity extends Activity implements View.OnClickListener {
    private PhotoView pv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_photo);
        initView();
    }

    private void initView() {
        pv= (PhotoView) findViewById(R.id.pv);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        pv.enable();
        ImageView iv=new ImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
        Info in = PhotoView.getImageViewInfo(iv);
        pv.animaFrom(in);
        pv.setAnimaDuring(3000);
        pv.animaTo(in, new Runnable() {
            @Override
            public void run() {

            }
        });
        pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pv.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return 0;
            }
        });
        pv.setMaxScale(5);
    }

    @Override
    public void onClick(View v) {
        Intent main=new Intent();
        main.setClass(this,Main.class);
        startActivity(main);

    }
}
