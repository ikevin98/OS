package com.example.prj_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Gallery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerManager manager;

    private RecyclerView recyclerGallery;
    private RecyclerAdapter adapter;
    private GalleryAdapter gadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        init();
    }

    /*----------------------------------------------------------------------menu.xml따로 있음
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_done:
                selectDone();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    */
     */


    /**
     * 레이아웃 초기화
     */
    private void initLayout() {
        recyclerGallery = (RecyclerView) findViewById(R.id.rv);
    }


    /**
     * 데이터 초기화
     */
    private void init() {
        //갤러리 리사이클러뷰 초기화
        initRecyclerGallery();
    }


    /**
     * 갤러리 아미지 데이터 초기화
     */
    private List<PhotoVO> initGalleryPathList() {
        manager = new RecyclerManager(getApplicationContext());
        //return mGalleryManager.getDatePhotoPathList(2015, 9, 19);
        return manager.getAllPhotoPathList();
    }


    /**
     * 확인 버튼 선택 시---------------------------------------------------------------------------

    private void selectDone() {

        List<PhotoVO> selectedPhotoList = galleryAdapter.getSelectedPhotoList();
        for (int i = 0; i < selectedPhotoList.size(); i++) {
            Log.i("", ">>> selectedPhotoList   :  " + selectedPhotoList.get(i).getImgPath());
        }
    }
     */


    /**
     * 갤러리 리사이클러뷰 초기화
     */
    private void initRecyclerGallery() {

        adapter = new RecyclerAdapter(MainActivity.this, initGalleryPathList(), R.layout.activity_item);
       //adapter.setOnItemClickListener(mOnItemClickListener);
        recyclerGallery.setAdapter(adapter);
        recyclerGallery.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerGallery.setItemAnimator(new DefaultItemAnimator());
        //recyclerGallery.addItemDecoration(new GridDividerDecoration(getResources(), R.drawable.divider_recycler_gallery));-----------------뭔지모르겠음
    }


    /**
     * 리사이클러뷰 아이템 선택시 호출 되는 리스너

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {

        @Override
        public void OnItemClick(GalleryAdapter.PhotoViewHolder photoViewHolder, int position) {

            PhotoVO photoVO = galleryAdapter.getmPhotoList().get(position);

            if(photoVO.isSelected()){
                photoVO.setSelected(false);
            }else{
                photoVO.setSelected(true);
            }

            galleryAdapter.getmPhotoList().set(position,photoVO);
            galleryAdapter.notifyDataSetChanged();

        }
    };*/
}
