package cn.edu.swufe.appframe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment mFragments[];
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtHome,rbtFunc,rbtSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mFragments = new Fragment[3];
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragmet_main);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragmet_func);
        mFragments[2] = fragmentManager.findFragmentById(R.id.fragmet_setting);

        fragmentTransaction =
                fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fragmentTransaction =
                    fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    fragmentTransaction.show(mFragments[0]).commit();
//                    Intent scrol = new Intent(MainActivity.this,ScrollingActivity.class);
//////                startActivity(scrol);
                    return true;
                case R.id.navigation_dashboard:
                    //TextMessage.setText(R.string.title_dashboard);
//                    Intent items = new Intent(MainActivity.this,ItemListActivity.class);
//                    startActivity(items);
                    fragmentTransaction.show(mFragments[1]).commit();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
//                    Intent my = new Intent(MainActivity.this,MyActivity.class);
//                    startActivity(my);
                    fragmentTransaction.show(mFragments[2]).commit();
                    return true;
            }
            return false;
        }
    };



}
