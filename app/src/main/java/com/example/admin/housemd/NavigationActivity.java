package com.example.admin.housemd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {

    NavigationView mp1NavigationView;
    DrawerLayout mp1NavigationLayout;
    FragmentManager mp1FragmentManager;
    FragmentTransaction mp1FragmentTransaction;
    Toolbar mp1_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mp1_toolbar = (Toolbar) findViewById(R.id.toolbar_mp1);
        mp1NavigationView = (NavigationView) findViewById(R.id.mainPage1DrawerView);
        mp1NavigationLayout = (DrawerLayout) findViewById(R.id.mainPage1DrawerLayout);


        mp1FragmentManager = getSupportFragmentManager();
        mp1FragmentTransaction = mp1FragmentManager.beginTransaction();
       // mp1FragmentTransaction.replace(R.id.containerToBeFilled, new Symptoms1Frag()).commit();

        mp1NavigationView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                getMenuInflater().inflate(R.menu.nav_menu, menu);
            }
        });

//        mp1NavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                android.support.v4.app.Fragment fragment = null;
//                Class fragmentClass = null;
//
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        fragmentClass = Symptoms1Frag.class;
//                        break;
//                    case R.id.symptoms:
//                        fragmentClass = Symptoms1Frag.class;
//                        break;
//                }
//                try {
//                    fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    fragmentManager.beginTransaction().replace(R.id.containerToBeFilled, fragment).commit();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                // Set action bar title
//                setTitle(item.getTitle());
//                // Close the navigation drawer
//                mp1NavigationLayout.closeDrawers();
//                return false;
//            }
//        });


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_mp1);
        ActionBarDrawerToggle mp1_DrawerToggle = new ActionBarDrawerToggle(this, mp1NavigationLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mp1NavigationLayout.setDrawerListener(mp1_DrawerToggle);

        mp1_DrawerToggle.syncState();
    }
}
