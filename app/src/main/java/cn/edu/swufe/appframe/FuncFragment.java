package cn.edu.swufe.appframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FuncFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fram_func,container);
    }

    public void onActivityGreate(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

}
