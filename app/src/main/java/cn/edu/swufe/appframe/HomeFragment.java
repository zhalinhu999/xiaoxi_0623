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

public class HomeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fram_home,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn_xueyuan=(Button)getActivity().findViewById(R.id.btn_xueyuan);
        Button btn_xuexiao=(Button)getActivity().findViewById(R.id.btn_xuexiao);
        Button btn_huodong=(Button)getActivity().findViewById(R.id.btn_huodong);
        Button btn_shetuan=(Button)getActivity().findViewById(R.id.btn_shetuan);

        btn_xueyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),XueyListActivity.class);
                startActivity(intent);
            }
        });
        btn_xuexiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollingActivity.class);
                startActivity(intent);
            }
        });
        btn_huodong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),HuodongFrams.class);
                startActivity(intent);
            }
        });
        btn_shetuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),ShetuanActivity.class);
                startActivity(intent);
            }
        });

    }



}
