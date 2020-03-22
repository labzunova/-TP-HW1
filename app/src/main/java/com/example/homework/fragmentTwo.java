package com.example.homework;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {  // fragment layout inflating
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

        TextView num = view.findViewById(R.id.textF2);
        num.setText(text);

        assert text != null;
        int numInt = Integer.parseInt(text);
        if (numInt % 2 == 0) num.setTextColor(Color.RED);
        else num.setTextColor(Color.BLUE);

     }

    static fragmentTwo newInstance(int num) { // state saving
        fragmentTwo fragment = new fragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("number",String.valueOf(num));
        fragment.setArguments(bundle);
        return fragment;
    }


}
