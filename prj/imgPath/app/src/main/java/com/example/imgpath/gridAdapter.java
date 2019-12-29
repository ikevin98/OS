package com.example.imgpath;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class gridAdapter extends BaseAdapter {
    Context context;
    ArrayList<PhotoVO> photoList;

    public void GridAdapter (ArrayList<PhotoVO> list) {
        photoList = list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new GridView.LayoutParams(parent.getWidth()/3, parent.getHeight()/3));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(1, 1, 1, 1);
        }
        else{imageView = (ImageView)convertView;}
        Bitmap myBitmap = BitmapFactory.decodeFile(photoList.get(position).getImgPath());
        imageView.setImageBitmap(myBitmap);

        //onCreate에서 정해준 크기로 이미지를 붙인다.

        return imageView;
    }
}
