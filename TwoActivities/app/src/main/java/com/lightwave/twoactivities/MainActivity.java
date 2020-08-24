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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        replyHeader = findViewById(R.id.text_header_reply);
        replyContent = findViewById(R.id.text_message_reply);
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
