package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.bm.library.Info;
import com.bm.library.PhotoView;
import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/5/31.
 */
public class PhoteActivity extends Activity {
    private PhotoView pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_photo);
        initView();
    }

    private void initView() {
        pv= (PhotoView) findViewById(R.id.pv);
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
}
