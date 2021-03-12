package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.testapp.adapter.DataAdapter;
import com.example.testapp.adapter.ListItem;
import com.example.testapp.adapter.RecOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener {
    private RecOnClickListener recOnClickListener;
    private DataAdapter adapter;
    private List<ListItem> listData;
    private RecyclerView rcViev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMenu();
        setRecOnClickListener();
        init();


    }

    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuFragmentList mMenuFragment = (MenuFragmentList) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuFragmentList();
            mMenuFragment.setNavItemSelectedListener(this);
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
    }

    @Override
    public void onNavItemSelectedListener(MenuItem item) {

    }
    private void init(){
        rcViev = findViewById(R.id.rcViev);
        rcViev.setLayoutManager(new LinearLayoutManager(this));
        listData = new ArrayList<>();
//        ListItem item = new ListItem();
//        item.setText("Говно ебучее");
//        item.setImageId(R.drawable.fon2);
//        ListItem item2 = new ListItem();
//        item2.setText("Java ебучая");
//        item2.setImageId(R.drawable.fon);
//        listData.add(item2);
//        listData.add(item);
//        listData.add(item);
//        listData.add(item);
//        listData.add(item);
//        listData.add(item);
//        listData.add(item);

        String [] planets = getResources().getStringArray(R.array.planets);
        int [] images = {R.drawable.fon, R.drawable.fon2, R.drawable.bec};
        for (String planet : planets){
            int i = 0;
            ListItem item = new ListItem();
            item.setText(planet);
            item.setImageId(images[i]);
            i++;
            listData.add(item);

        }
        adapter = new DataAdapter(this, recOnClickListener, listData);
        rcViev.setAdapter(adapter);

    }
    private void setRecOnClickListener(){

        recOnClickListener = new RecOnClickListener() {
            @Override
            public void onItemCliked(int pos) {
                Toast.makeText(MainActivity.this, "заебался блять" + pos, Toast.LENGTH_SHORT).show();

                listData.clear();
                String [] planets = getResources().getStringArray(R.array.stars);
                int [] images = {R.drawable.fon, R.drawable.fon2, R.drawable.bec};
                for (String planet : planets){
                    int i = 0;
                    ListItem item = new ListItem();
                    item.setText(planet);
                    item.setImageId(images[i]);
                    i++;
                    listData.add(item);

                }
                adapter = new DataAdapter(MainActivity.this, recOnClickListener, listData);
                rcViev.setAdapter(adapter);


            }
        };
    }
}