package com.lightwave.activities_intents_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String logCat = MainActivity.class.getSimpleName();
    private int counter = 0;
    private TextView countView;
    public static final String EXTRA_MSG_REQ = "extra.MSG";

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(logCat, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(logCat, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(logCat, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(logCat, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(logCat, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(logCat, "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(logCat, "-------");
        Log.d(logCat, "onCreate");
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
