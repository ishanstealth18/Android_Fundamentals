package com.lightwave.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String logTag = MainActivity.class.getSimpleName();
    private EditText webText;
    private EditText locationText;
    private EditText shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webText = findViewById(R.id.website_edittext);
        locationText = findViewById(R.id.location_edittext);
        shareText = findViewById(R.id.share_edittext);

    }

    public void openWebsite(View view) {
        String url = webText.getText().toString();
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webPage);

        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d(logTag,"Intent cannot resolve!!");
        }

    }

    public void openLocation(View view) {
        String location = locationText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);

        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d(logTag,"Intent cannot resolve!!");
        }
    }

    public void shareText(View view) {
        String shareStr = shareText.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(shareStr)
                .startChooser();
    }
}
