package cn.edu.swufe.appframe;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadActivity extends AppCompatActivity {

    Button btn_cycle,btn_book;
    ImageButton btn_imag;
    EditText title,detail;
    ImageView uppic;

    final  String TAG = "Upload";

    Handler handler;

    public static final int CHOOSE_PHOTO=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        title=(EditText)findViewById(R.id.up_title2);
        detail=(EditText)findViewById(R.id.up_detail2);
        btn_cycle=(Button)findViewById(R.id.btn_upcycle);
        btn_book=(Button)findViewById(R.id.btn_upbook);
        btn_imag=(ImageButton)findViewById(R.id.btn_uppic);
        uppic=(ImageView)findViewById(R.id.img_uppic);




        btn_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(UploadActivity.this,CycleActivity.class);

                String title2 = title.getText().toString();
                String detail2 = detail.getText().toString();

                m.putExtra("title",title2);
                m.putExtra("detail",detail2);

                Log.i(TAG, "onClick: title2" + title2);
                Log.i(TAG, "onClick: detail2" + detail2);
                startActivity(m);
            }
        });
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(UploadActivity.this,BookActivity.class);
                String title2 = title.getText().toString();
                String detail2 = detail.getText().toString();
                m.putExtra("title",title2);
                m.putExtra("detail",detail2);
                startActivity(m);
            }
        });


    }

}
