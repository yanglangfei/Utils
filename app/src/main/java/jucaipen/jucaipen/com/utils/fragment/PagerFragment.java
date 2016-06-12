package jucaipen.jucaipen.com.utils.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhy.changeskin.SkinManager;

import java.util.ArrayList;
import java.util.List;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.adapter.PAdapter;
import me.gujun.android.taggroup.TagGroup;


/**
 * Created by jucaipen on 16/6/1.
 */
public class PagerFragment extends Fragment implements ViewPager.OnPageChangeListener, TagGroup.OnTagClickListener, TagGroup.OnTagChangeListener {
    public ViewPager vp;
    private PAdapter adapter;
    private ArrayList<ImageView> ivs;
    private List<ImageView> imageViews=new ArrayList<>();
    private  int images[]={R.mipmap.ad3,R.mipmap.ad1,R.mipmap.ad2,R.mipmap.ad3,R.mipmap.ad1};
    private View view;
    private TagGroup tg;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==100){
                int item=vp.getCurrentItem();
                //    item  0   1   2   3  4      5
                if(item<adapter.getCount()-2){
                    vp.setCurrentItem(item+1);
                }else{
                    vp.setCurrentItem(1,false);
                }
                handler.sendEmptyMessageDelayed(100,2000);
            }
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
        ivs=new ArrayList<>();
        imageViews.clear();
        ivs.add((ImageView) view.findViewById(R.id.iv1));
        ivs.add((ImageView) view.findViewById(R.id.iv2));
        ivs.add((ImageView) view.findViewById(R.id.iv3));
        tg= (TagGroup) view.findViewById(R.id.tg);
        tg.setTags("精选","娱乐","体育");
        tg.setOnTagClickListener(this);
        tg.setOnTagChangeListener(this);
        for(int i=0;i<images.length;i++){
            ImageView iv=new ImageView(getContext());
            iv.setImageResource(images[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(iv);
        }
        adapter.notifyDataSetChanged();
        vp.setCurrentItem(1);
        handler.sendEmptyMessageDelayed(100,1000);
        vp.setOnPageChangeListener(this);
   }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(vp!=null){
                vp.setCurrentItem(1);
                handler.sendEmptyMessageDelayed(100,2000);
            }
        }else {
            handler.removeMessages(100);
        }
    }

    private void initView() {
        vp= (ViewPager) view.findViewById(R.id.vp);
        adapter=new PAdapter(imageViews);
        vp.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i=0;i<ivs.size();i++){
            if(i==position-1){
                ivs.get(i).setImageResource(R.mipmap.yiru_xiaoyuan);
            }else{
                ivs.get(i).setImageResource(R.mipmap.xiaoyuan);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTagClick(String tag) {
        Toast.makeText(getActivity(), ""+tag, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAppend(TagGroup tagGroup, String tag) {

    }

    @Override
    public void onDelete(TagGroup tagGroup, String tag) {

    }
}
