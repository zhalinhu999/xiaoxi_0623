package cn.edu.swufe.appframe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FuncFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fram_func,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn_fun01=(Button)getActivity().findViewById(R.id.btn_func01);
        Button btn_fun02=(Button)getActivity().findViewById(R.id.btn_func02);
        Button btn_fun03=(Button)getActivity().findViewById(R.id.btn_func03);
        Button btn_fun04=(Button)getActivity().findViewById(R.id.btn_func04);
        Button btn_fun05=(Button)getActivity().findViewById(R.id.btn_func05);
        Button btn_fun06=(Button)getActivity().findViewById(R.id.btn_func06);
        Button btn_fun07=(Button)getActivity().findViewById(R.id.btn_func07);

        btn_fun01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String http="https://jwc.swufe.edu.cn/";
                Intent intent = new Intent(getActivity(),Func_First.class);
                intent.putExtra("http",http);
                startActivity(intent);
            }
        });
        btn_fun02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String http="http://202.115.115.133/";
                Intent intent = new Intent(getActivity(),Func_First.class);
                intent.putExtra("http",http);
                startActivity(intent);
            }
        });
        btn_fun03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String http="http://jwcwx.swufe.edu.cn/p/cx.asp";
                Intent intent = new Intent(getActivity(),Func_First.class);
                intent.putExtra("http",http);
                startActivity(intent);
            }
        });
        btn_fun04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LostfindActivity.class);
                startActivity(intent);
            }
        });
        btn_fun05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String http="http://ghy.swufe.edu.cn/";
                Intent intent = new Intent(getActivity(),Func_First.class);
                intent.putExtra("http",http);
                startActivity(intent);
            }
        });
        btn_fun06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CycleActivity.class);
                startActivity(intent);
            }
        });
        btn_fun07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BookActivity.class);
                startActivity(intent);
            }
        });

    }



}
