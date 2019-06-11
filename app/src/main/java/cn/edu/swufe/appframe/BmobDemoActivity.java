package cn.edu.swufe.appframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class BmobDemoActivity extends AppCompatActivity {

    private final String TAG="Bmob";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmob_demo);
        Bmob.initialize(this, "a517d5170732ad0f00ceb71c39f88581");

        Bmob_user p2 = new Bmob_user();
        p2.setName("小西");
        p2.setAddress("四川成都");
        Log.i(TAG, "onCreate: Name=" + p2.getName() );
        Log.i(TAG, "onCreate: Name=......." );
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e!=null){
                    Toast.makeText(BmobDemoActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(BmobDemoActivity.this,"success",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}



