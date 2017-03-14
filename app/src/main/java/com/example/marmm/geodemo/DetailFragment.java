package com.example.marmm.geodemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */

public class DetailFragment extends Fragment {

    private int geoObjImage;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(int geoObjectImgID) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("Geo object image id", geoObjectImgID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            //Obtain the parameters
            //Fill imageview and textview with the input parameters
            //Note that you need to add "getView()" here
            geoObjImage = bundle.getInt("Geo object image id");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView geoObjImageView = (ImageView) view.findViewById(R.id.DF_image);
        geoObjImageView.setImageResource(geoObjImage);

        return view;
    }
}