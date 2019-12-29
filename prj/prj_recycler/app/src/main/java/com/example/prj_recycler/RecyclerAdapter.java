package com.example.prj_recycler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    // adapter에 들어갈 list
    private ArrayList<PhotoVO> photoList = new ArrayList<PhotoVO>();

    // LayoutInflater를 이용하여 전 단계에서 만들었던 activity_item.xml을 inflate
    // return 인자는 ViewHolder
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }

    // Item을 하나, 하나 보여주는(bind 되는) 함수--------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(photoList.get(position));
    }

    // RecyclerView의 총 개수
    @Override
    public int getItemCount() {
        return photoList.size();
    }

    // 외부에서 item을 추가시킬 함수
    void addItem(PhotoVO pv) {
        photoList.add(pv);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        //받은 데이터를 뷰에 보여줌 ex) textView.setText(data.getContent());
        void onBind(PhotoVO pv) {
            Bitmap bp = BitmapFactory.decodeFile(pv.getImgPath());
            bp=Bitmap.createScaledBitmap(bp,150,150,true);
            imageView.setImageBitmap(bp);
        }
    }
}



