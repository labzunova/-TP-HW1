package com.example.homework;

//import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragmentTwo extends Fragment {
    TextView digit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = "No";
        Bundle arguments = getArguments();
        if (arguments != null) {
            text = arguments.getString("number");
        }

        TextView num = (TextView)view.findViewById(R.id.textF2);
        num.setText(text);

        int numInt = Integer.parseInt(text);
        if (numInt % 2 == 0) num.setTextColor(Color.parseColor("#B22222")); else num.setTextColor(Color.parseColor("#4682B4"));
    }

    public static fragmentTwo newInstance(int num) {
        fragmentTwo fragment = new fragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("number",String.valueOf(num));
        fragment.setArguments(bundle);
        return fragment;
    }


}
