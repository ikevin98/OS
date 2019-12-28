package com.example.gallleryimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

import static android.os.Environment.DIRECTORY_DCIM;

public class MainActivity extends AppCompatActivity {

    myPicture mp;
    GridView gv;
    String[] proj= { MediaStore.Images.Media.DATA };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.gv);


        myGridAdapter adapter = new myGridAdapter(this);
        gv.setAdapter(adapter);

    }

    //----Uri에서 실제 경로 가져오기
    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if(cursor.moveToFirst()){;
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }
    //실제경로 반환----


    //그리드뷰 어댑터
    public class myGridAdapter extends BaseAdapter {
        Context context;
        //이미지 하나씩 가져오기

        public myGridAdapter(Context context){
            this.context=context;
        }
        @Override
        public int getCount() {
            return proj.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(final int position, View convertview, ViewGroup parent) {
            mp= new myPicture(context);

            if (imageCursor != null && imageCursor.moveToFirst()){
                String fileName;
                int dataCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);

                do {
                    fileName = imageCursor.getString(dataCol);
                    if (fileName != null){
                        // fileName(이미지 파일명)
                    }
                } while (imageCursor.moveToNext());

                imageCursor.close();
            }


            //mypicture가 들어갈 gridview설정
            mp.setLayoutParams(new GridView.LayoutParams(parent.getWidth()/3,parent.getHeight()/3));
            mp.setPadding(2,2,2,2);


            mp.invalidate();
            return mp;
        }
    }
}
