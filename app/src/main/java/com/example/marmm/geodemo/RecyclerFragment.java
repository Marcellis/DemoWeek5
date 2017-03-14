package com.example.marmm.geodemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.example.marmm.geodemo.GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS;
import static com.example.marmm.geodemo.GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {


    private ArrayList<GeoObject> mGeoObjects;
    private GeoObjectAdapter mAdapter;
    private RecyclerView mGeoRecyclerView;


    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        mGeoRecyclerView = (RecyclerView) view.findViewById(R.id.geoRecyclerview);


        mGeoObjects = new ArrayList<GeoObject>();

        for(int i=0; i<PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {

            mGeoObjects.add(new GeoObject(PRE_DEFINED_GEO_OBJECT_NAMES[i], PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));
        }


        // some examples with different layouts
        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3); //2 cells per row
        mGeoRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GeoObjectAdapter(getActivity(), mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return view;
    }

}
