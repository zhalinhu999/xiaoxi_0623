package cn.edu.swufe.appframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Func_First extends AppCompatActivity {

    private WebView webView;
    private long exitTime = 0;

    private final String TAG="Func_first" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_func__first);

        Intent intent = getIntent();
        String http = intent.getStringExtra("http");
        Log.i(TAG, "onCreate:获取的网址 "+http);

        if(http.equals("http://202.115.115.133/")){
            Toast.makeText(Func_First.this,"需要连接西财校园网",Toast.LENGTH_SHORT).show();
        }else if(http.equals("http://ghy.swufe.edu.cn/")){
            Toast.makeText(Func_First.this,"需要连接西财校园网",Toast.LENGTH_SHORT).show();
        }

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
