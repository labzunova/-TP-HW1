package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements interface1{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       if (savedInstanceState == null)  {
           getSupportFragmentManager()
                   .beginTransaction()
                   .add(R.id.fr1,new fragmentOne())
                   .commit();
       }
    }


    @Override
    public void onItemClick(int num) { // fragment replacing
        Fragment fragment = fragmentTwo.newInstance(num);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fr1,fragment)
                .addToBackStack("close")
                .commit();
    }
}
