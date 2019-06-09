package cn.edu.swufe.appframe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class XueyActivity extends AppCompatActivity  {

    private String TAG ="XueyActivity";
    Handler handler;
    int num;
    String str;

    private WebView webView;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuey);
        String title = getIntent().getStringExtra("title");
        String http = getIntent().getStringExtra("http");

        Bundle bundle = this.getIntent().getExtras();
        num = bundle.getInt("position");
        Log.i(TAG, "onCreate: 接收到的position：" + num);

        ((TextView) findViewById(R.id.xy_name)).setText(title);
        ((TextView) findViewById(R.id.xy_http)).setText(http);

        if(num == 0){
            str = "ssss1111";
        }else if(num==1){
            str = "ssss222";
        }

        ((TextView) findViewById(R.id.xy_detail)).setText(str);

//        WebView webView = (WebView) findViewById(R.id.xuey_scan);
//        webView.loadUrl("http://www.baidu.com");

        webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient() {
            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);  //设置WebView属性,运行执行js脚本
        webView.loadUrl(http);                              //调用loadUrl方法为WebView加入链接
        setContentView(webView);                           //调用Activity提供的setContentView将webView显示出来
    }


    //我们需要重写回退按钮的时间,当用户点击回退按钮：
    //1.webView.canGoBack()判断网页是否能后退,可以则goback()
    //2.如果不可以连续点击两次退出App,否则弹出提示Toast
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出页面",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }

        }
    }
}
