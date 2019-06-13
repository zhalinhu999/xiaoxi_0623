package cn.edu.swufe.appframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class UpdatepwdActivity extends AppCompatActivity {

    EditText up_pwd,up_pwd2;
    Button btn_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepwd);

        Bmob.initialize(this, "a517d5170732ad0f00ceb71c39f88581");

        up_pwd = findViewById(R.id.up_pwd);
        up_pwd2 = findViewById(R.id.up_pwd2);

        btn_up = findViewById(R.id.btn_up);

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = up_pwd.getText().toString();
                String pwd2 = up_pwd2.getText().toString();
                BmobUser.updateCurrentUserPassword(pwd, pwd2, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(UpdatepwdActivity.this,"密码修改成功，可以用新密码进行登录啦！",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(UpdatepwdActivity.this,"密码修改失败"+e,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
