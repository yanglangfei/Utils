package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.adapter.PAdapter;

/**
 * Created by jucaipen on 16/6/1.
 */
public class PagerActivity extends Fragment {
    public ViewPager vp;
    private PAdapter adapter;
    private List<ImageView> imageViews=new ArrayList<>();
    private  int images[]={R.mipmap.ad3,R.mipmap.ad1,R.mipmap.ad2,R.mipmap.ad3,R.mipmap.ad1};
    private View view;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int item=vp.getCurrentItem();
            //    item  0   1   2   3  4      5
            if(item<adapter.getCount()-2){
                vp.setCurrentItem(item+1);
            }else{
                vp.setCurrentItem(1,false);
            }
            handler.sendEmptyMessageDelayed(100,1000);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.ui_pager,container,false);
        initView();
        initData();
        return view;
    }


    private void initData() {
        for(int i=0;i<images.length;i++){
            ImageView iv=new ImageView(getContext());
            iv.setImageResource(images[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(iv);
        }
        adapter.notifyDataSetChanged();
        vp.setCurrentItem(1);
        handler.sendEmptyMessageDelayed(100,1000);
   }


    private void initView() {
        vp= (ViewPager) view.findViewById(R.id.vp);
        adapter=new PAdapter(imageViews);
        vp.setAdapter(adapter);
    }
}
