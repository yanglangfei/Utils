package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import jucaipen.jucaipen.com.utils.R;


/**
 * Created by jucaipen on 16/6/13.
 */
public class ErrorActivity extends Activity implements View.OnClickListener {
    private Button to_main;
    private  Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_error);
        initView();
    }

    private void initView() {
        to_main= (Button) findViewById(R.id.to_main);
        stop= (Button) findViewById(R.id.stop);
        to_main.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.to_main:
                //返回主页
                Class<? extends Activity> restore = CustomActivityOnCrash.getRestartActivityClass();
                String error = CustomActivityOnCrash.getAllErrorDetailsFromIntent(v.getContext(), getIntent());
                Intent main=new Intent();
                main.setClass(ErrorActivity.this,restore);
                startActivity(main);
                break;
            case  R.id.stop:
                //退出程序
                CustomActivityOnCrash.closeApplication(this);
                break;
            default:
                break;

        }
    }
}
