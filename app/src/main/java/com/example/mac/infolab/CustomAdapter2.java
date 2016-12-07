package com.example.mac.infolab;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Acer on 7/13/2016.
 */
public class CustomAdapter2  extends PagerAdapter {
    Context context;

    Integer[] imageIDs={
            R.drawable.skip,
            R.drawable.biking,
            R.drawable.jump,
            R.drawable.jog,
            R.drawable.benefits};

    public CustomAdapter2(Context context){
        this.context = context;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.image_item2, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView1);
        imageView.setImageResource(imageIDs[position]);

        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageIDs.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }

}



