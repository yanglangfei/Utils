package jucaipen.jucaipen.com.utils.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.fragment.HomeFragment;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by jucaipen on 16/6/14.
 *
 *   Activity + Fragment 框架    git 地址  https://github.com/yanglangfei/Fragmentation
 */
public class TestActivity extends SupportActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_test);
        if(savedInstanceState==null){
            start(HomeFragment.newInstance());
        }
    }

    @Override
    protected int setContainerId() {
        return R.id.fl_container;
    }

    /**
     *  设置全局动画，在SupportFragment可以自由更改其动画
     */
    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        // 默认竖向(和安卓5.0以上的动画相同)
        return super.onCreateFragmentAnimator();
        // 设置横向(和安卓4.x动画相同)
        // return new DefaultHorizontalAnimator();
        // 设置自定义动画
        // return new FragmentAnimator(enter,exit,popEnter,popExit);

        // 这里注意
        // new FragmentAnimator(enter,exit,popEnter,popExit)的4个参数与官方setCustomAnimations(enter,exit,popEnter,popExit)
        // 并不一致，对于官方来说Fragment出栈时的动画对应的是popExit（即第4个参数）
        // 对于FragmentAnimator来说Fragment出栈时的动画对应的是exit参数（即第2个参数）
        // 这里和官方不一致的原因主要出于我们绝大多数人认为enter,exit才是对应进出栈动画的角度考虑的。
    }
}
