package com.example.apple.bottomnaviationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, android.support.v4.view.ViewPager.OnPageChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();



    }



    private android.support.v4.view.ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private TextView mTitle;

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bnv);
        mViewPager = (android.support.v4.view.ViewPager) findViewById(R.id.ViewPager);
    }

    private void initData() {
    }

    private void initListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        //系统默认选中第一个,但是系统选中第一个不执行onNavigationItemSelected(MenuItem)方法,如果要求刚进入页面就执行clickTabOne()方法,则手动调用选中第一个
        mBottomNavigationView.setSelectedItemId(R.id.tab_one);//根据具体情况调用
        mViewPager.addOnPageChangeListener(this);
        //为viewpager设置adapter
        mViewPager.setAdapter(new ViewPager(getSupportFragmentManager()));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //BottomNaviationView和ViewPager联动,当BottomNaviationView的某个tab按钮被选中了,同时设置ViewPager对应的页面被选中
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.tab_one:
                clickTabOne();
                return true;//返回true,否则tab按钮不变色,未被选中
            case R.id.tab_two:
                clickTabTwo();
                return true;
            case R.id.tab_three:
                clickTabThree();
                return true;

            default:
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        //ViewPager和BottomNaviationView联动,当ViewPager的某个页面被选中了,同时设置BottomNaviationView对应的tab按钮被选中
        switch (position) {
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.tab_one);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.tab_two);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.tab_three);
                break;

            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private void clickTabOne() {
        //为防止隔页切换时,滑过中间页面的问题,去除页面切换缓慢滑动的动画效果
        mViewPager.setCurrentItem(0, false);

    }

    private void clickTabTwo() {
        mViewPager.setCurrentItem(1, false);

    }

    private void clickTabThree() {
        mViewPager.setCurrentItem(2, false);

    }




}
