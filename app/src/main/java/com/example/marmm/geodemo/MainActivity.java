package com.example.marmm.geodemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static com.example.marmm.geodemo.GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS;
import static com.example.marmm.geodemo.GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES;

public class MainActivity extends AppCompatActivity {


    private ArrayList<GeoObject> mGeoObjects;
    private GeoObjectAdapter mAdapter;
    private RecyclerView mGeoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGeoRecyclerView = (RecyclerView) findViewById(R.id.geoRecyclerview);


        mGeoObjects = new ArrayList<GeoObject>();

        for(int i=0; i<PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {

            mGeoObjects.add(new GeoObject(PRE_DEFINED_GEO_OBJECT_NAMES[i], PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));
        }


        // some examples with different layouts
      LinearLayoutManager mLayoutManager
              = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3); //2 cells per row
        mGeoRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
