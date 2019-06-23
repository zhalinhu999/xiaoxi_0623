package cn.edu.swufe.appframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class CycleActivity extends AppCompatActivity {

    private CardView cardView,cardView1;
    final String TAG = "cycle";
    ImageView img;
    private static  int pics[] = {R.mipmap.cycle05};
    String detail="";

    TextView cyc_title,cyc_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle);

        cyc_title = findViewById(R.id.cyc_title);
        cyc_detail = findViewById(R.id.cyc_detail);
        img = findViewById(R.id.cycle_imag);

        String title = "04" + getIntent().getStringExtra("title");
        String detail = getIntent().getStringExtra("detail");

        Log.i(TAG, "onCreate: title"+ title);
        Log.i(TAG, "onCreate: detail"+ detail);

        cardView = (CardView)findViewById(R.id.cardView);
        cardView.setRadius(8);//设置图片圆角的半径大小
        cardView.setCardElevation(8);//设置阴影部分大小
        cardView.setContentPadding(5,5,5,5);//设置图片距离阴影大小

        if (detail.length()>=1){
            img.setImageResource(pics[0]);
            cyc_title.setText(title);
            cyc_detail.setText(detail);
        }


    }


}
