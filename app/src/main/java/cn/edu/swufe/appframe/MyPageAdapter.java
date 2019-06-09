package cn.edu.swufe.appframe;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {

    private String[] title = new String[]{"百团大战","金色之秋","五月诗存","草坪音乐"};
    public MyPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if ((position==0)){
            return new Fragment_01();
        }else if(position==1) {
            return new Fragment_02();
        }else if(position==2){
            return new Fragment_03();
        }else {
            return new Fragment_04();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return title[position];
    }

    @Override
    public int getCount() {
        return 4;
    }
}
