package cn.edu.swufe.appframe;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LostfindActivity extends ListActivity implements Runnable,AdapterView.OnItemClickListener ,AdapterView.OnItemLongClickListener{

    private String TAG ="LostfindActivity";

    Handler handler;
    private List<HashMap<String,String>>listItems;//存放文字、图片信息
    private SimpleAdapter listItemAdapter;//适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListView();

        MyAdapter myAdapter = new MyAdapter(this,R.layout.activity_lostfind, (ArrayList<HashMap<String, String>>) listItems);//改变类型？
        this.setListAdapter(myAdapter);

        Thread t =new Thread(this);
        t.start();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==4){
                    listItems  = (List<HashMap<String,String>>) msg.obj;

                    listItemAdapter = new SimpleAdapter(LostfindActivity.this,listItems,
                            R.layout.activity_lostfind,
                            new String[]{"ItemTitle","ItemDetail"},
                            new int[]{R.id.itemTitle,R.id.itemDetail}
                    );
                    setListAdapter(listItemAdapter);
                }
                super.handleMessage(msg);
            }
        };

        getListView().setOnItemClickListener(this);
        // getListView().setOnLongClickListener(this);
        getListView().setOnItemLongClickListener(this);
    }
    private void initListView(){
        listItems = new ArrayList<HashMap<String,String>>();
        for (int i = 0;i<10;i++){
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("ItemTitle","Rate:" + i);//标题文字
            //map.put("ItemDetail","Detail:" + i);//详情描述 key不重复
            map.put("ItemDetail","" + i);//便于转换
            listItems.add(map);
        }
        //生成适配器
        listItemAdapter = new SimpleAdapter(this,listItems,
                R.layout.list_item,
                new String[]{"ItemTitle","ItemDetail"},
                new int[]{R.id.itemTitle,R.id.itemDetail}
        );
    }

    @Override
    public void run() {
        //获取网络数据,带回到list的主线程
        List<HashMap<String,String>> retList = new ArrayList<HashMap<String,String>>();
        Document doc = null;

        try {
            doc = Jsoup.connect("http://page.renren.com/601664416/fdoing").get();
            Log.i(TAG,"run"+doc.title());

            Elements body = doc.getElementsByTag("body");
            Element body1 = body.get(0);
            //Log.i(TAG,"run"+tables);
            //获取td中的数据

            Elements h3 = body1.getElementsByTag("h3");
            Elements span = body1.getElementsByTag("span");

            for(int i=0;i<h3.size();i++){
                //Element td1 = tds.get(i+1);
                Element wenb = h3.get(i);

                Log.i(TAG,"run:"+ wenb.text() );
                String str1 = wenb.text();
                String http = "http://page.renren.com/601664416/fdoing";
                HashMap<String,String> map = new HashMap<String, String>();

                map.put("ItemTitle",str1);
                map.put("ItemDetail",http);
                retList.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Message msg = handler.obtainMessage(4);
        msg.obj = retList;
        handler.sendMessage(msg);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"onItemClick: parent" + parent);
        Log.i(TAG,"onItemClick: view" + view);
        Log.i(TAG,"onItemClick: position" + position);
        Log.i(TAG,"onItemClick: id" + id);


        HashMap<String,String> map = (HashMap<String, String>) getListView().getItemAtPosition(position);
        String titleStr = map.get("ItemTitle");
        String detailStr = map.get("ItemDetail");

        //打开新的页面传入参数
        Intent xueyDetail = new Intent(this,XueyActivity.class);
        xueyDetail.putExtra("title",titleStr);
        xueyDetail.putExtra("http",detailStr);

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        xueyDetail.putExtras(bundle);
        startActivity(xueyDetail);


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        Log.i(TAG, "onItemLongClick: 长按列表position " + position);
        //删除操作
        //listItems.remove(position);
        //listItemAdapter.notifyDataSetChanged();
        //构造对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("请确认是否删除当前数据").setPositiveButton("是",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "onClick: 对话框事件处理");
                listItems.remove(position);
                listItemAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton("否",null);
        builder.create().show();

        Log.i(TAG, "onItemLongClick: size=" + listItems.size());
        //return false; //短按也生效
        return true;
    }
}
