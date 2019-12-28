package com.example.gallleryimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import java.util.jar.Attributes;

public class myPicture extends View {
    String imgPath=null;

    public myPicture(Context c){
        super(c);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(imgPath != null){
            Bitmap bp = BitmapFactory.decodeFile(imgPath);
            canvas.drawBitmap(bp,0,0,null);
            bp.recycle();
        }
    }
}
