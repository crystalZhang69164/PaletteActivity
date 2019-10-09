package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {
    //needed to change the background color of new activity
    public static final String COLOR = "edu.temple.PaletteActivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declares an intent
        final Intent intent = new Intent(this,CanvasActivity.class);
        //array of colors
        //final String colors[]={"Pick a color","Blue","Green","Red","Purple","Cyan","Magenta","Lime","Aqua","Silver","Yellow"};


        //Resources res = [context.this]getResources();

        //color_array is the name of the array on the string xml file
        //retrieving the string array resource and storing it in a array of colors variable
        final String[] colors = getResources().getStringArray(R.array.color_array);
        final String[] colors_hex = getResources().getStringArray(R.array.color_hexes);

        //finds the reference to the spinner with id spinner1
        Spinner spinner = findViewById(R.id.spinner1);
        //final Layout layout = findViewById(R.id.layout1);

        //making an instance of the color adapter
        ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colors, colors_hex);



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
        });


        //sets the spinner adapter to our custom adapter
        spinner.setAdapter(adapter);



    }


}
