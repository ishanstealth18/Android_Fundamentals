package com.lightwave.activities_intent_codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView viewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        viewContent = findViewById(R.id.mainContent);
        Intent intent = getIntent();
        String showContent = intent.getStringExtra(MainActivity.EXTRA_MSG_REQUEST);
        viewContent.setText(showContent);

    }
}
