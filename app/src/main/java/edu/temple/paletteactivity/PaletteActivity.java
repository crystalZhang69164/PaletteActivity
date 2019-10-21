package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.colorSelectedInterface {
    //needed to change the background color of new activity
    public static final String COLOR = "edu.temple.PaletteActivity.MESSAGE";
    FragmentManager fragmentManager;
    Fragment paletteFragment;
    Fragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets the array of colors from the string.xml file
        String[] colors = getResources().getStringArray(R.array.color_array);
        String[] hex_colors = getResources().getStringArray(R.array.color_hexes);

        //DirectoryFragment directoryFragment = new DirectoryFragment.newInstance(getResources().getStringArray("color_array"));


        //bundle.putStringArray("colors", getResources().getStringArray(colors));

        //makes a new instance of the palette fragment
        paletteFragment = PaletteFragment.newInstance(colors, hex_colors);


        //puts the fragment onto the activity layout and commits the transaction
        getSupportFragmentManager().beginTransaction().add(R.id.layout1,paletteFragment).commit();


    }


    @Override
    public void colorSelected(int position) {
        //add a canvas fragment w/ brackground color
        if(position != 0){
            String[] color_hex = getResources().getStringArray(R.array.color_hexes);
            canvasFragment = CanvasFragment.newInstance(color_hex[position]);

            //.addToBackStack(null) makes it so that when the user presses the back button on the phone it would go back to the
            //palette activity instead of closing the app
            //adds the canvasFragment on top and commit the changes
            getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.layout1, canvasFragment).commit();
        }

    }

}
