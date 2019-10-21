package edu.temple.paletteactivity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {


    public PaletteFragment() {
        // Required empty public constructor
    }

    String[] colors;
    String[] color_hex;
    public final static String COLOR_KEY = "color_array";
    public  final static String HEX_KEY = "color_hex";
    //Fragment fragment = new Fragment();
    //Fragment fragmentParent = new Fragment();
    colorSelectedInterface fragmentParent;

    //activity made the context
    //checks if activity implements the interface
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //if it implemented the frag methods
        if(context instanceof colorSelectedInterface){
            fragmentParent = (colorSelectedInterface) context;

        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        if(bundle!= null){
            colors = bundle.getStringArray(COLOR_KEY);
            color_hex = bundle.getStringArray(HEX_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_palette, container, false);

        Spinner spinner = fragView.findViewById(R.id.spinner1);




        //declares an intent
        //final Intent intent = new Intent(this,CanvasActivity.class);
        //array of colors
        //final String colors[]={"Pick a color","Blue","Green","Red","Purple","Cyan","Magenta","Lime","Aqua","Silver","Yellow"};


        //Resources res = [context.this]getResources();

        //color_array is the name of the array on the string xml file
        //retrieving the string array resource and storing it in a array of colors variable
        final String[] colors = getResources().getStringArray(R.array.color_array);
        //array of colors in hexadecimal
        final String[] colors_hex = getResources().getStringArray(R.array.color_hexes);

        //getActivity().findViewById(R.id.spinner1);
        //finds the reference to the spinner with id spinner1
        //Spinner spinner = findViewById(R.id.spinner1);
        //final Layout layout = findViewById(R.id.layout1);

        //making an instance of the color adapter
        ColorAdapter adapter = new ColorAdapter(getActivity(), colors, colors_hex);


        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fragmentParent.colorSelected(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        return fragView;


        /*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //sets background color of view to white in the spinner
                view.setBackgroundColor(Color.WHITE);



                //if position is 1 or more change the background color in the second activity
                //if position is 0 the background color of 2nd activity will not pop up when
                //the item in the spinner is selected
                if(position !=0){
                    //sets the background of the layout to w/e was selected for the spinner
                    findViewById(R.id.layout1).setBackgroundColor(Color.parseColor(colors_hex[position]));
                    //selected color
                    String selectedColor = colors_hex[position];
                    intent.putExtra(COLOR,selectedColor);
                    //starts a new activity
                    startActivity(intent);
                }




            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); */


        //sets the spinner adapter to our custom adapter
        //spinner.setAdapter(adapter);





    // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_palette, container, false);
        //return fragView;
    }



    //builds the fragment and returns the palette fragment obj
    public static PaletteFragment newInstance(String[] colors, String[] color_hex){
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle bundle = new Bundle();

        //puts the string of colors into the bundle
        bundle.putStringArray(COLOR_KEY, colors);

        bundle.putStringArray(HEX_KEY,color_hex);
        //passes the bundle into the palette argument
        paletteFragment.setArguments(bundle);

        return paletteFragment;
    }

    public interface colorSelectedInterface{
        //method in the interface
        void colorSelected(int position);


    }

}
