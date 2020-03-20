package com.example.homework;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.homework.R;

import java.util.ArrayList;


public class fragmentOne extends Fragment {

    private ArrayList<Integer> data;
    private MyRecyclerViewAdapter adapter;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = view.findViewById(R.id.list);

        data = new ArrayList<>(); // empty array creating
        int colCount;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            colCount = 3;
        else colCount = 4;

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), colCount));
            adapter = new MyRecyclerViewAdapter(data);
            recyclerView.setAdapter(adapter);
        }

        for (int i = 1; i <= 100; i++) data.add(i);

        Button btn = view.findViewById(R.id.Add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(data.size() + 1);
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }


    // ADAPTER CREATING
    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

        private ArrayList<Integer> data;

        MyRecyclerViewAdapter(ArrayList<Integer> data) { // constructor
            this.data = data;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // viewHolder creating
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            if (position % 2 == 0) {
                holder.number.setText(String.valueOf(position + 1));
                holder.number.setTextColor(Color.parseColor("#B22222"));
            } else {
                holder.number.setText(String.valueOf(position + 1));
                holder.number.setTextColor(Color.parseColor("#4682B4"));
            }
            holder.number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView digit = v.findViewById(v.getId());
                    int number = Integer.parseInt((String) digit.getText());
                    ((interface1) activity).onItemClick(number);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }


        class ViewHolder extends RecyclerView.ViewHolder {
            TextView number;

            ViewHolder(View itemView) {
                super(itemView);
                number = itemView.findViewById(R.id.info_text);

            }
        }


    }
}

