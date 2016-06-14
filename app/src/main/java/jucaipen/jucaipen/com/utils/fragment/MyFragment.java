package jucaipen.jucaipen.com.utils.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.bumptech.glide.Glide;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.jungly.gridpasswordview.GridPasswordView;
import com.meetic.marypopup.MaryPopup;
import com.wx.goodview.GoodView;

import net.steamcrafted.loadtoast.LoadToast;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/6/1.
 *
 *    gif 图片框架 git 地址  https://github.com/yanglangfei/GifImageView
 *
 *    Glide 多种形状图片框架  git 项目地址   https://github.com/yanglangfei/glide-transformations
 *
 *    点赞效果    git 项目地址   https://github.com/yanglangfei/GoodView
 *
 *
 *    GridPasswordView  密码输入框架   git 项目地址  https://github.com/yanglangfei/GridPasswordView
 *
 *
 *    图表 git 项目地址   https://github.com/yanglangfei/hellocharts-android
 *                     https://github.com/yanglangfei/HoloGraphLibrary
 *
 *     日志输出工具类     git 项目地址   https://github.com/yanglangfei/LogUtils
 *
 *
 *
 *     MaryPopup 项目地址      https://github.com/yanglangfei/MaryPopup
 *
 *
 */
public class MyFragment extends Fragment {

    private View view;
    private ImageView iv;
    private Button zan;
    private GoodView gv;
    private GridPasswordView pswView;
    private HTextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.ui_my,container,false);
        initview();
        return view;
    }

    private void initview() {
        iv= (ImageView) view.findViewById(R.id.iv);
        pswView= (GridPasswordView) view.findViewById(R.id.pswView);
        Glide.with(getActivity()).load("http://img1.imgtn.bdimg.com/it/u=998216620,3976144567&fm=21&gp=0.jpg")
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .bitmapTransform(new CropCircleTransformation(getActivity()))
                .into(iv);

         gv=new GoodView(getActivity());
        zan= (Button) view.findViewById(R.id.zan);
        zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setTextInfo("+1", Color.RED,20);
                gv.show(zan);

            }
        });


        MaryPopup.with(getActivity()).cancellable(true).blackOverlayColor(Color.parseColor("#DD444444"))
                .backgroundColor(Color.parseColor("#EFF4F5"))
                .draggable(true)
                .content(iv).from(zan).show();




        pswView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {
                Toast.makeText(getActivity(), ""+psw, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInputFinish(String psw) {

            }
        });

        final LoadToast toast=new LoadToast(getActivity());
        toast.setText("load...");
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.success();
            }
        },5000);


        LogUtils.configAllowLog=true;
        LogUtils.configTagPrefix="abc";
        LogUtils.d("1233");



        text= (HTextView) view.findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setAnimateType(HTextViewType.RAINBOW);
                text.animateText("hello");
            }
        });

    }

}
