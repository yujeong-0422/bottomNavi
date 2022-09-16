package com.lab.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private FragmentManager fm;
    private FragmentTransaction ft;
    private frag_home frag_home;
    private frag_info frag_info;
    private frag_setting frag_setting;
    private frag_notification frag_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.home:
                        setFrag(0);
                        break;

                    case R.id.notification:
                        setFrag(1);
                        break;

                    case R.id.info:
                        setFrag(2);
                        break;

                    case R.id.setting:
                        setFrag(3);
                        break;

                }
                return true;
            }
        });



        frag_home = new frag_home();
        frag_info = new frag_info();
        frag_notification = new frag_notification();
        frag_setting = new frag_setting();

        setFrag(0);

    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag_home);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, frag_notification);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.main_frame, frag_info);
                ft.commit();
                break;

            case 3:
                ft.replace(R.id.main_frame, frag_setting);
                ft.commit();
                break;

        }
    }




}