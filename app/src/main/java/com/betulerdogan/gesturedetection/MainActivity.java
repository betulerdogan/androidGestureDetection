package com.betulerdogan.gesturedetection;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gDetect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener{
        private float flingMin=100;
        private float velocityMin=100;

        boolean forward=false;
        boolean backward=false;
    }
}
