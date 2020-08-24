package com.lightwave.activities_intents_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SavedData_Activity extends AppCompatActivity {

    private static final String logCat = SavedData_Activity.class.getSimpleName();
    private TextView displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_data_);
        displayData = findViewById(R.id.savedDataView);
        Intent intent = getIntent();
        String receiveMsg = intent.getStringExtra(MainActivity.EXTRA_MSG_REQ);
        displayData.setText(receiveMsg);

    }
}
