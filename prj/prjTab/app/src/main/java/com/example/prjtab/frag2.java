package com.example.prjtab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.prjtab.R;

import java.util.List;

public class frag2 extends Fragment {
    public frag2(){};

    private GalleryManager mGalleryManager;
    private RecyclerView recyclerGallery;
    private GalleryAdapter galleryAdapter;
    public RequestManager mGlideRequestManager;

    @Nullable
    @Override
    //xml 레이아웃이 인플레이트 되고 자바소스 코드와 연결이된다.
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_tab2, container, false);

            initLayout(rootView);
            initRecyclerGallery();

        return rootView;
    }

    //레이아웃 초기화
    private void initLayout(ViewGroup v) {
        recyclerGallery = (RecyclerView) v.findViewById(R.id.recyclerGallery);
    }

    //갤러리 리사이클러뷰 초기화


    //갤러리 이미지 데이터 초기화
    private List<PhotoVO> initGalleryPathList() {

        mGalleryManager = new GalleryManager(MainActivity.context);
        //return mGalleryManager.getDatePhotoPathList(2015, 9, 19);
        return mGalleryManager.getAllPhotoPathList();
    }

    //갤러리 리사이클러뷰 초기화
    private void initRecyclerGallery() {

        galleryAdapter = new GalleryAdapter(this, initGalleryPathList(), R.layout.item_photo);
        //galleryAdapter.setOnItemClickListener(mOnItemClickListener);
        recyclerGallery.setAdapter(galleryAdapter);
        recyclerGallery.setLayoutManager(new GridLayoutManager(MainActivity.context, 4));
        recyclerGallery.setItemAnimator(new DefaultItemAnimator());
        //recyclerGallery.addItemDecoration(new GridDividerDecoration(getResources(), R.drawable.divider_recycler_gallery));---------------------???????????????????
    }
}
