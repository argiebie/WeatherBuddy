package com.wb.android.weatherbuddy;

/**
 * Created by RB on 2017-05-04.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThreeDayForecast extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.threedayforecast,container,false);
        return rootView;
    }
}