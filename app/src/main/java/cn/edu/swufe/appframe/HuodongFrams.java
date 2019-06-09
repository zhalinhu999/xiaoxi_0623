package cn.edu.swufe.appframe;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class HuodongFrams extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frams_huodong);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        MyPageAdapter pageAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        TabLayout tableLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tableLayout.setupWithViewPager(viewPager);
    }

}
