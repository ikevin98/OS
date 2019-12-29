package com.example.prj1229;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GalleryManager mGalleryManager;

    private RecyclerView recyclerGallery;
    private myAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        init();
    }

    //레이아웃 초기화
    private void initLayout() {

        recyclerGallery = (RecyclerView) findViewById(R.id.recyclerGallery);
    }

    //갤러리 리사이클러뷰 초기화
    private void init() {
        initRecyclerGallery();
    }

    //갤러리 이미지 데이터 초기화
    private List<PhotoVO> initGalleryPathList() {

        mGalleryManager = new GalleryManager(getApplicationContext());
        //return mGalleryManager.getDatePhotoPathList(2015, 9, 19);
        return mGalleryManager.getAllPhotoPathList();
    }

    //갤러리 리사이클러뷰 초기화
    private void initRecyclerGallery() {

        galleryAdapter = new myAdapter(MainActivity.this, initGalleryPathList(), R.layout.item);
        //galleryAdapter.setOnItemClickListener(mOnItemClickListener);
        recyclerGallery.setAdapter(galleryAdapter);
        recyclerGallery.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerGallery.setItemAnimator(new DefaultItemAnimator());
        //recyclerGallery.addItemDecoration(new GridDividerDecoration(getResources(), R.drawable.divider_recycler_gallery));---------------------???????????????????
    }

}
