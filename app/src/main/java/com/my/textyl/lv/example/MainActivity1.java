package com.my.textyl.lv.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.my.textyl.R;
import com.my.textyl.lv.example.fragment.MainFragment;


public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        if (savedInstanceState == null) {
            loadFragment(new MainFragment(), false);
        }
    }
    public void loadFragment(final Fragment fragment, boolean addToBackStack) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_container, fragment, fragment.getClass().getName());

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }
}