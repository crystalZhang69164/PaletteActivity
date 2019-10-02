package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);


        //sets the background color of the second activity once an item has been selected from the spinner
        findViewById(R.id.canvasLayout).setBackgroundColor(Color.parseColor(getIntent().getStringExtra(PaletteActivity.COLOR)));


    }
}
