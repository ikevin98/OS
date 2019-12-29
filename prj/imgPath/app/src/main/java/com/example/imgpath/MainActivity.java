package com.example.imgpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String[] proj= { MediaStore.Images.Media.DATA };
    String txt;
    Context context;
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this.context;
        gv=(GridView)findViewById(R.id.gv);

        gridAdapter adapter = new gridAdapter(context);
        gv.setAdapter(adapter);
     }

    public List<PhotoVO> getAllPhotoPathList() {

        ArrayList<PhotoVO> photoList = new ArrayList<>();

        Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.MediaColumns.DATA
        };

        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        int columnIndexData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()) {

            PhotoVO photoVO = new PhotoVO(cursor.getString(columnIndexData),false);
            photoList.add(photoVO);
        }

        cursor.close();

        return photoList;
    }

}
