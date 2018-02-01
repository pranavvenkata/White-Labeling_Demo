package com.actigage.whitelabelingdemo;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fragments.RedFragment1;
import fragments.RedFragment2;
import fragments.RedFragment3;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPagerAndTab(viewPager,BuildConfig.FLAVOR);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    private void setupViewPagerAndTab(ViewPager viewPager,String Flavor) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        switch (Flavor) {
            case "redbottomnavigation":
                adapter.addFragment(new RedFragment1(), "RED1");
                adapter.addFragment(new RedFragment2(), "RED2");
                adapter.addFragment(new RedFragment3(), "RED3");
                break;
            case "greenbottomnavigation":
                break;
            case "yellowbottomnavigation":
                break;
            default:
                break;
        }
        viewPager.setAdapter(adapter);
        setupTabIcons(Flavor);
    }
    private void setupTabIcons(String Flavor) {
        switch (Flavor) {
            case "redbottomnavigation":
                tabLayout.getTabAt(0).setIcon(R.drawable.agenda);
                tabLayout.getTabAt(1).setIcon(R.drawable.sponsors);
                tabLayout.getTabAt(2).setIcon(R.drawable.speakers);
                break;
            case "greenbottomnavigation":
                break;
            case "yellowbottomnavigation":
                break;
            default:
                break;
        }
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
