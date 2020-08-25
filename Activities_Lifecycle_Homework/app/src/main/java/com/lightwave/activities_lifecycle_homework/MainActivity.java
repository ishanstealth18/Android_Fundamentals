package com.lightwave.activities_lifecycle_homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countTextView;
    private static final String logTag = MainActivity.class.getSimpleName();
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTextView = findViewById(R.id.countView);

        if(savedInstanceState != null)
        {
            countTextView.setText(savedInstanceState.getString("countStatus"));

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("countStatus",countTextView.getText().toString());
        Log.d(logTag,"Bundle value: " + countTextView.getText().toString());

    }

    public void startCount(View view) {
        counter++;
        if(countTextView != null)
        {
            countTextView.setText(Integer.toString(counter));
        }

    }
}
