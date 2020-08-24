package com.lightwave.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static  final String logCat = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "extra.REPLY";
    private EditText mReply;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(logCat, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(logCat, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(logCat, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(logCat, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(logCat, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(logCat, "onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

    }

    public void returnReply(View view) {

        String replyMsg = mReply.getText().toString();
        Intent replyIntent = new Intent(this,MainActivity.class);
        replyIntent.putExtra(EXTRA_REPLY,replyMsg);
        setResult(RESULT_OK,replyIntent);
        Log.d(logCat, "End SecondActivity");
        finish();

    }
}
