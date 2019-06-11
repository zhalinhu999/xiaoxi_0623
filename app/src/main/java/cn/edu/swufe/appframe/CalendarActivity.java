package cn.edu.swufe.appframe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void Call(View btn){
        Intent Tel = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:13698568546"));
        startActivity(Tel);
    }

}
