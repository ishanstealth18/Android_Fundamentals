package com.lightwave.activities_intents_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView countView;
    public static final String EXTRA_MSG_REQ = "extra.MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = findViewById(R.id.countView);
    }

    public void startCount(View view) {
        counter++;
        if(countView != null)
        {
            countView.setText(Integer.toString(counter));
        }

    }

    public void sendHello(View view) {
        Intent intent = new Intent(this,SavedData_Activity.class);
        String sendMsg = "Hello!!\n\t" +counter;
        intent.putExtra(EXTRA_MSG_REQ,sendMsg);
        startActivity(intent);
    }
}
