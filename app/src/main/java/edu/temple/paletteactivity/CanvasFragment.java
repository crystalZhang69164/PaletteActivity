package edu.temple.paletteactivity;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {


    final static String HEX_KEY = "color_hexes";
    private String color_hexes;



    public CanvasFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        if(bundle!= null){


            //colors = bundle.getStringArray(COLOR_KEY);
            color_hexes = bundle.getString(HEX_KEY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canvas, container, false);

        view.setBackgroundColor(Color.parseColor(color_hexes));
        // Inflate the layout for this fragment
        return view;
    }

    public void displayColor(String colorName){


    }

    //creates an instance of the canvas fragment
    public static CanvasFragment newInstance (String color_hexes){
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle bundle = new Bundle();

        //puts the colors in hexes into the bundle
        bundle.putString(HEX_KEY, color_hexes);
        //set the args of the canvas w/ the bundle whenever it is created
        canvasFragment.setArguments(bundle);
        return canvasFragment;
    }



}
