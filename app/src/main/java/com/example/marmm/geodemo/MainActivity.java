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

public class MainActivity extends AppCompatActivity implements GeoObjectAdapter.GeoObjectCellSelected {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerFragment recyclerFragment = new RecyclerFragment();
//and make it active through the FragmentManager class
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.recyclerFragment, recyclerFragment, "recyclerFragment")
                .addToBackStack(null)
                .commit();

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

    @Override
    public void GeoObjectCellSelected(int geoOjectImageID) {
        //Create an instance of the DetailFragment class
        DetailFragment detailFragment = DetailFragment.newInstance(geoOjectImageID);

        //and make it active through the FragmentManager class
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailFragment, detailFragment, "detailFragment")
                .addToBackStack(null)
                .commit();
    }

}

