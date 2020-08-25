package com.lightwave.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String logCat = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.lightwave.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView replyHeader;
    private TextView replyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(logCat, "-------");
        Log.d(logCat, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        replyHeader = findViewById(R.id.text_header_reply);
        replyContent = findViewById(R.id.text_message_reply);

        if(savedInstanceState != null)
        {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if(isVisible)
            {
                replyHeader.setVisibility(View.VISIBLE);
                replyContent.setText(savedInstanceState.getString("reply_text"));
                replyContent.setVisibility(View.VISIBLE);
            }
        }
    }

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(replyHeader.getVisibility() == View.VISIBLE)
        {
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_text",replyContent.getText().toString());
        }
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

    public void launchSecondActivity(View view) {
        Log.d(logCat,"Button clicked!!");
        Intent intent = new Intent(this,SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(TEXT_REQUEST == requestCode)
        {
            if(resultCode == RESULT_OK)
            {
                String replyReceived = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                replyHeader.setVisibility(View.VISIBLE);
                replyContent.setText(replyReceived);
                replyContent.setVisibility(View.VISIBLE);

            }
        }

    }
}
