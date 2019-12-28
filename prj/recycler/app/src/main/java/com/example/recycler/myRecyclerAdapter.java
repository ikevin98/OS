package com.example.recycler;

import androidx.recyclerview.widget.RecyclerView;

public class myRecyclerAdapter extends RecyclerView.Adapter<myRecyclerAdapter.myViewHolder> {
    private int[] imgSet;

    public myRecyclerAdapter(int [] imgSet){
        this.imgSet=imgSet;
    }


}
