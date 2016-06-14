package jucaipen.jucaipen.com.utils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/6/1.
 *
 *    gif 图片框架 git 地址  https://github.com/yanglangfei/GifImageView
 *
 *    Glide 多种形状图片框架  git 项目地址   https://github.com/yanglangfei/glide-transformations
 *
 *
 */
public class MyFragment extends Fragment {

    private View view;
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.ui_my,container,false);
        initview();
        return view;
    }

    private void initview() {
        iv= (ImageView) view.findViewById(R.id.iv);
        Glide.with(getActivity()).load("http://img1.imgtn.bdimg.com/it/u=998216620,3976144567&fm=21&gp=0.jpg")
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .bitmapTransform(new CropCircleTransformation(getActivity()))
                .into(iv);
    }

}
