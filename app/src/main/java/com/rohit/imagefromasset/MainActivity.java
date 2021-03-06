package com.rohit.imagefromasset;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ImageView mImageView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiating the objects
        mImageView = findViewById(R.id.imageView);
        mButton = findViewById(R.id.button);


        // handling the button click event
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // getting the image from the asset and showing it into the imageView

                try {
                    AssetManager assetManager = getAssets();
                    InputStream ims = assetManager.open("ic_background.png");
                    Drawable d = Drawable.createFromStream(ims, null);
                    mImageView.setImageDrawable(d);
                } catch (IOException ex) {
                    Log.d(TAG, "onCreate:" ,ex.fillInStackTrace());
                }
            }
        });


    }
}
