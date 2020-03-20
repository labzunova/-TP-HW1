package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements interface1{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*   if (savedInstanceState == null)  {
           getSupportFragmentManager()
                   .beginTransaction()
                   .add(R.id.fragment1,new fragmentOne())
                   .commit();
       } */
    }


    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment2);
    }

    @Override
    public void onItemClick(int num) {
        Fragment fragment = fragmentTwo.newInstance(num);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment1,fragment)
                .commit();
    }
}
