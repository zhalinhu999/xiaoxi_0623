package cn.edu.swufe.appframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisActivity extends AppCompatActivity {
    EditText regis_id,regis_pwd,regis_email,regis_phone;
    Button btn_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        Bmob.initialize(this, "a517d5170732ad0f00ceb71c39f88581");

        regis_id = findViewById(R.id.regis_id);
        regis_pwd = findViewById(R.id.regis_pwd);
        regis_email = findViewById(R.id.regis_email);
        regis_phone = findViewById(R.id.regis_phone);

        btn_regis = findViewById(R.id.btn_regis);

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BmobUser user = new BmobUser();
                user.setUsername(regis_id.getText().toString());
                user.setPassword(regis_pwd.getText().toString());
                user.setEmail(regis_email.getText().toString());
                user.setMobilePhoneNumber(regis_phone.getText().toString());

                user.signUp(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser user, BmobException e) {
                        if(e==null)
                        {
                            Toast.makeText(RegisActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            Intent m = new Intent(RegisActivity.this,LoginActivity.class);
                            startActivity(m);
                        }else
                        {
                            Toast.makeText(RegisActivity.this,"注册失败"+e,Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}
