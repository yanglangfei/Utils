package jucaipen.jucaipen.com.utils.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by jucaipen on 16/6/1.
 */
public class PAdapter extends PagerAdapter{
    private List<ImageView> images;

    public PAdapter(List<ImageView> images) {
        this.images=images;

    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View image=images.get(position);
        container.addView(image);
        return image;
    }


}
