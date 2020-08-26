package com.lightwave.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView uriView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Uri uri = intent.getData();


        if(uri != null)
        {
            String uri_string = "URI: " +uri.toString();
            uriView = findViewById(R.id.text_uri_message);
            uriView.setText(uri_string);
        }
    }
}
