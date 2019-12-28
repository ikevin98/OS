package com.example.recycler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class Item{
        private Drawable Dicon;
        public void setIcon(Drawable icon) {Dicon=icon;}
        public Drawable getIcon(Drawable icon) {return Dicon;}
    }
}
