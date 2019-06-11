package cn.edu.swufe.appframe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {
    private final String TAG="Login";
    Button btn_reg,btn_log;
    EditText userid,userpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "a517d5170732ad0f00ceb71c39f88581");

        userid = findViewById(R.id.userid);
        userpwd = findViewById(R.id.userpwd);

        btn_reg = findViewById(R.id.regis);
        btn_log = findViewById(R.id.login);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(LoginActivity.this,RegisActivity.class);
                startActivity(m);
            }
        });


        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser userlogin = new BmobUser();
                userlogin.setUsername(userid.getText().toString());
                userlogin.setPassword(userpwd.getText().toString());
                userlogin.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e==null){
                            Toast.makeText(LoginActivity.this,bmobUser.getUsername()+"登录成功",Toast.LENGTH_SHORT).show();
                            Intent m = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(m);
                        }else {
                            Toast.makeText(LoginActivity.this,"登录失败"+e,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        BmobUser bmobUser = BmobUser.getCurrentUser();//不重复登录
        if(bmobUser != null){
            // 允许用户使用应用
            Intent m = new Intent(this,MainActivity.class);
            startActivity(m);
        }else{
            //缓存用户对象为空时， 可打开用户注册界面…
//            Intent m = new Intent(this,RegisActivity.class);
//            startActivity(m);
        }
    }
}
