package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.adapter.FpAdapter;
import jucaipen.jucaipen.com.utils.fragment.MyFragment;
import jucaipen.jucaipen.com.utils.fragment.PagerFragment;
import jucaipen.jucaipen.com.utils.fragment.PlayFragment;

/**
 * Created by jucaipen on 16/6/1.
 */
public class Main extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private ViewPager main_vp;
    private List<Fragment> fragments=new ArrayList<>();
    private FpAdapter adapter;
    private MyFragment my;
    private PlayFragment play;
    private  PagerFragment pf;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        initView();
        initData();
    }

    private void initData() {
        pf=new PagerFragment();
        my=new MyFragment();
        play=new PlayFragment();
        fragments.add(pf);
        fragments.add(play);
        fragments.add(my);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        main_vp= (ViewPager) findViewById(R.id.main_vp);
        adapter=new FpAdapter(getSupportFragmentManager(),fragments);
        main_vp.setAdapter(adapter);
        rg= (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case  R.id.mian:
                main_vp.setCurrentItem(0);
                break;
            case  R.id.play:
                main_vp.setCurrentItem(1);
                break;
            case  R.id.my:
                main_vp.setCurrentItem(2);
                break;
            default:
                break;

        }
    }
}
