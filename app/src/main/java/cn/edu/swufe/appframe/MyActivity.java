package cn.edu.swufe.appframe;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;

public class MyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SensorManager sensorManager;
    private Vibrator vibrator;
    private static String strs[]  ={"夏日的柳湖","秋日的情人坡","春日的体育馆","鸟瞰四季西财","冬日的光华门"};
    private static  int pics[] = {R.mipmap.index_2,R.mipmap.index_3,R.mipmap.index_4,R.mipmap.index6,
            R.mipmap.index7};
    private ImageView img;
    private TextView text;
    private String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Bmob.initialize(this, "a517d5170732ad0f00ceb71c39f88581");
        TextView selfid =  findViewById(R.id.btn_selfid);
        TextView selfemail =  findViewById(R.id.btn_selfemail);

        img = findViewById(R.id.imgView);
        text = findViewById(R.id.textlabel);
        sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "摇一摇会发现美丽西财~", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_calendar) {
            Intent calen = new Intent(this,CalendarActivity.class);
            startActivity(calen);
        } else if (id == R.id.nav_mima) {
            Intent up = new Intent(this,UpdatepwdActivity.class);
            startActivity(up);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Login(View btn){
        Intent Login = new Intent(MyActivity.this,LoginActivity.class);
        //Intent Web = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
        startActivity(Login);
    }

    protected  void onResume(){
        super.onResume();
        if(sensorManager !=null){// 注册监听器
            sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(sensorManager != null){
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    //重感应监听
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            Log.i(TAG,"x[" + x + "]y[" + y + "]z[" + z + "]");

            int medumValue = 14;
            if(Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue){
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = 10;
                handler.sendMessage(msg);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 10:
                    //
                    Log.i(TAG,"检测到摇晃，执行操作");
                    java.util.Random r = new java.util.Random();
                    int num = Math.abs(r.nextInt())%5;
                    text.setText(strs[num]);
                    img.setImageResource(pics[num]);
                    break;
            }
        }
    };
}
