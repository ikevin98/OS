package com.example.prjtab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    TabLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp=(ViewPager)findViewById(R.id.vp);
        tl=(TabLayout)findViewById(R.id.tabLayout);



        //뷰페이저 어댑터 추가
        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager());

        frag1 fg1 = new frag1();
        adapter.addItem(fg1);

        frag2 fg2 = new frag2();
        adapter.addItem(fg2);

        frag3 fg3 = new frag3();
        adapter.addItem(fg3);

        vp.setAdapter(adapter);

        tl.addOnTabSelectedListener(pagerListener);

        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));

    }

    class MoviePagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }

    TabLayout.OnTabSelectedListener pagerListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            vp.setCurrentItem(tab.getPosition());
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) { }
        @Override
        public void onTabReselected(TabLayout.Tab tab) { }
    };
}
