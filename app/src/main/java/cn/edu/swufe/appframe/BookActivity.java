package cn.edu.swufe.appframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    TextView book_title;
    ImageView img;
    String m="";
    private static  int pics[] = {R.mipmap.book5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        book_title = findViewById(R.id.book_titil);
        img = findViewById(R.id.book_imag);

        String title = getIntent().getStringExtra("title");
        String detail = getIntent().getStringExtra("detail");

        String m = title + detail;



        if (m.length()>=1){
            img.setImageResource(pics[0]);
            book_title.setText(m);
        }


    }
}
