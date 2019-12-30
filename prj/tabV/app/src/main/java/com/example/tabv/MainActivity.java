package com.example.tabv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends AppCompatActivity {
    TabHost mtabHost;
    LinearLayout tab1, tab2, tab3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtabHost = (TabHost)findViewById(R.id.tabHost);
        mtabHost.setup();

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"tab1")
        TabHost.TabSpec ts1 = mtabHost.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.tab1) ;
        ts1.setIndicator("TAB 1") ;
        mtabHost.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = mtabHost.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.tab2) ;
        ts2.setIndicator("TAB 2") ;
        mtabHost.addTab(ts2) ;

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = mtabHost.newTabSpec("Tab Spec 3") ;
        ts3.setContent(R.id.tab3) ;
        ts3.setIndicator("TAB 3") ;
        mtabHost.addTab(ts3) ;

        tab1=(LinearLayout)findViewById(R.id.tab1);
        tab2=(LinearLayout)findViewById(R.id.tab2);
        tab3=(LinearLayout)findViewById(R.id.tab3);

        OnSwipeTouchListener onSwipeTouchListener = new OnSwipeTouchListener(MainActivity.this);
        tab1.setOnTouchListener(onSwipeTouchListener);
        tab2.setOnTouchListener(onSwipeTouchListener);
        tab3.setOnTouchListener(onSwipeTouchListener);
    }



}
