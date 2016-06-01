package jucaipen.jucaipen.com.utils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/6/1.
 */
public class MyFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.ui_my,container,false);
        return view;
    }
}
