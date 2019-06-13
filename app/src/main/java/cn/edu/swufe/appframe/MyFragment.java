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

import cn.bmob.v3.BmobUser;

public class MyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fram_my,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn_geren=(Button)getActivity().findViewById(R.id.btn_mygeren);
        Button btn_zhuce=(Button)getActivity().findViewById(R.id.btn_myzhuce);
        Button btn_tuichu=(Button)getActivity().findViewById(R.id.btn_mytuichu);

        btn_geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MyActivity.class);
                startActivity(intent);
            }
        });
        btn_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),RegisActivity.class);
                startActivity(intent);
            }
        });

        btn_tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BmobUser.logOut();   //清除缓存用户对象
                BmobUser currentUser = BmobUser.getCurrentUser(); // 现在的currentUser是null了

                Intent intent = new Intent(getActivity().getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}
