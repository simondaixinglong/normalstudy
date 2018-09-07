package com.simon.study.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simon.study.R;

/**
 * @author simon
 * @description:
 * @date 2018/8/6
 * @since 1.0
 */
public class TabLayoutAndViewPager extends AppCompatActivity {

    private String[] titleArray = {"Chats", "Contacts", "Discover", "Me", "Chats", "Contacts", "Discover", "Me"};
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tablayout_viewpager);

        tabLayout = findViewById(R.id.tl);
        viewPager = findViewById(R.id.vp);

        TabAdapter tabAdapter = new TabAdapter();
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    public class TabAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TextView textView = new TextView(TabLayoutAndViewPager.this);
            textView.setText(titleArray[position]);
            textView.setGravity(Gravity.CENTER);
            container.addView(textView, new LinearLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
            return textView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleArray[position];
        }
    }
}
