package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.adapter.FpAdapter;

/**
 * Created by jucaipen on 16/6/1.
 */
public class Main extends FragmentActivity {
    private ViewPager main_vp;
    private List<Fragment> fragments=new ArrayList<>();
    private FpAdapter adapter;
    private  PagerActivity pf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        initView();
        initData();
    }

    private void initData() {
        pf=new PagerActivity();
        fragments.add(pf);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        main_vp= (ViewPager) findViewById(R.id.main_vp);
        adapter=new FpAdapter(getSupportFragmentManager(),fragments);
        main_vp.setAdapter(adapter);



    }
}
